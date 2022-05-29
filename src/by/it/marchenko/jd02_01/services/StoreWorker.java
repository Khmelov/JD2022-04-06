package by.it.marchenko.jd02_01.services;

import by.it.marchenko.jd02_01.models.Customer;
import by.it.marchenko.jd02_01.Printer;
import by.it.marchenko.jd02_01.models.Store;
import by.it.marchenko.jd02_01.exception.StoreException;
import by.it.marchenko.jd02_01.repository.GoodRepo;
import by.it.marchenko.jd02_01.repository.PriceListRepo;
import by.it.marchenko.jd02_01.repository.StockRepo;
import by.it.marchenko.jd02_01.utility.Delayer;
import by.it.marchenko.jd02_01.utility.RandomGenerator;

import java.util.HashSet;
import java.util.Set;

import static by.it.marchenko.jd02_01.constants.StoreConstant.*;
import static by.it.marchenko.jd02_01.constants.StoreExceptionConstant.INTERRUPTED_EXCEPTION_MESSAGE;

public class StoreWorker extends Thread {

    private final Printer out;
    private final Store store;
    private final StockRepo stockRepo;
    private final GoodRepo goodRepo;
    private final PriceListRepo priceRepo;
    //private final GoodWorker


    public StoreWorker(StockRepo stockRepo, Store store, GoodRepo goodRepo, PriceListRepo priceRepo, Printer out) {
        this.stockRepo = stockRepo;
        this.priceRepo = priceRepo;
        this.out = out;
        this.store = store;
        this.goodRepo = goodRepo;
    }

    @Override
    public void run() {
        // TODO call StockWorker for creating stock
        StockWorker stockWorker = new StockWorker(stockRepo, goodRepo, priceRepo);
        stockWorker.start();
        out.println("Stock init in progress.");
        while (stockWorker.isAlive()) {
            out.print(".");
            Delayer.performDelay(1000);
        }
        out.println("\nStock init finished.");


        openStore();
        workStore();
        closeSore();
    }

    private void openStore() {
        out.println(store + OPENED_MESSAGE);
    }

    private void closeSore() {
        out.println(store + CLOSED_MESSAGE);
    }

    private void workStore() {
        Set<CustomerWorker> customerWorkerSet = new HashSet<>();
        for (int workTime = 0; workTime < WORK_TIME; workTime++) {
            int customerCountPerSecond = generateCustomerCountPerSecond(SIMPLY_CUSTOMER_LIMITATION);
            for (int customerCount = 0; customerCount < customerCountPerSecond; customerCount++) {
                Customer customer = new Customer();
                CustomerWorker customerWorker = new CustomerWorker(customer, stockRepo, /*goodWorker,*/ store, out);
                customerWorker.start();
                customerWorkerSet.add(customerWorker);
                Delayer.performDelay(REAL_ONE_SECOND);
            }
        }
        for (CustomerWorker customerWorker : customerWorkerSet) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                throw new StoreException(INTERRUPTED_EXCEPTION_MESSAGE, e);
            }

        }
    }

    private int generateCustomerCountPerSecond(@SuppressWarnings("SameParameterValue") boolean mode) {
        if (mode == SIMPLY_CUSTOMER_LIMITATION) {
            return RandomGenerator.getRandom(MAX_CUSTOMERS_COUNT_PER_SECOND);
        } else {
            //TODO implement complexCustomerLimitation
            return 10;
        }
    }
}
