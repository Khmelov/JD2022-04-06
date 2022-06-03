package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.Printer;
import by.it.marchenko.jd02_02.exception.StoreException;
import by.it.marchenko.jd02_02.models.Customer;
import by.it.marchenko.jd02_02.models.Pensioner;
import by.it.marchenko.jd02_02.models.Store;
import by.it.marchenko.jd02_02.models.Student;
import by.it.marchenko.jd02_02.repository.GoodRepo;
import by.it.marchenko.jd02_02.repository.PriceListRepo;
import by.it.marchenko.jd02_02.repository.StockRepo;
import by.it.marchenko.jd02_02.utility.CustomerChecker;
import by.it.marchenko.jd02_02.utility.Delayer;
import by.it.marchenko.jd02_02.utility.RandomGenerator;

import java.util.HashSet;
import java.util.Set;

import static by.it.marchenko.jd02_02.constants.StoreConstant.*;
import static by.it.marchenko.jd02_02.constants.StoreExceptionConstant.INTERRUPTED_EXCEPTION_MESSAGE;

public class StoreWorker extends Thread {

    public static final String STOCK_INIT_IN_PROGRESS = "Stock init in progress";
    public static final String STOCK_INIT_FINISHED = "\nStock init finished.";
    public static final String INIT_PROGRESS_INDICATOR_SYMBOL = ".";
    public static final int INIT_PROGRESS_DELAY_TIME = 20;

    public static final double MAX_COUNTER_TEMP =
            (double) ((MAX_MIDDLE_MINUTE_CUSTOMER_AMOUNT - STARTED_CUSTOMER_AMOUNT)) / HALF_A_MINUTE;
    public static final double MIN_COUNTER_TEMP =
            (double) ((MIN_MIDDLE_MINUTE_CUSTOMER_AMOUNT - STARTED_CUSTOMER_AMOUNT)) / HALF_A_MINUTE;


    private final Printer out;
    private final Store store;
    private final StockRepo stockRepo;
    private final GoodRepo goodRepo;
    private final PriceListRepo priceRepo;

    private int totalCustomerCount = 0;
    private int currentCustomerCount = 0;

    public StoreWorker(StockRepo stockRepo, Store store, GoodRepo goodRepo, PriceListRepo priceRepo, Printer out) {
        this.stockRepo = stockRepo;
        this.priceRepo = priceRepo;
        this.out = out;
        this.store = store;
        this.goodRepo = goodRepo;
    }

    @Override
    public void run() {
        storeInit();
        openStore();
        new CustomerChecker(this).start();

        workStore();
        closeSore();
        out.printf("Total customer count: %s%n", totalCustomerCount);
        out.printf("Current customer count: %s%n", currentCustomerCount);

    }

    private void storeInit() {
        StockWorker stockWorker = new StockWorker(stockRepo, goodRepo, priceRepo);
        stockWorker.start();
        out.print(STOCK_INIT_IN_PROGRESS);
        while (stockWorker.isAlive()) {
            out.print(INIT_PROGRESS_INDICATOR_SYMBOL);
            new Delayer().performDelay(INIT_PROGRESS_DELAY_TIME);
        }
        out.println(STOCK_INIT_FINISHED);
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
            //int customerCountPerSecond = generateCustomerCountPerSecond(SIMPLY_CUSTOMER_LIMITATION);
            int customerCountPerSecond = generateCustomerCountPerSecond(workTime);
            for (int customerCount = 0; customerCount < customerCountPerSecond; customerCount++) {
                Customer customer = generateCustomer();
                CustomerWorker customerWorker = new CustomerWorker(customer, store,
                        goodRepo, stockRepo, priceRepo, out, this);
                customerWorkerSet.add(customerWorker);
                customerWorker.start();
            }
            new Delayer().performDelay(REAL_ONE_SECOND);
        }
        for (CustomerWorker customerWorker : customerWorkerSet) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                throw new StoreException(INTERRUPTED_EXCEPTION_MESSAGE, e);
            }

        }
    }

    private int generateCustomerCountPerSecond(int time) {
        int timePeriod = time % ONE_MINUTE;
        int calcTime = (timePeriod < ONE_MINUTE / 2) ? timePeriod : ONE_MINUTE - timePeriod;
        double expectedMinCustomerCount = (MIN_COUNTER_TEMP * calcTime + STARTED_CUSTOMER_AMOUNT);
        double expectedMaxCustomerCount = (MAX_COUNTER_TEMP * calcTime + STARTED_CUSTOMER_AMOUNT);
        if (currentCustomerCount > expectedMaxCustomerCount) {
            return 0;
        } else if (currentCustomerCount < expectedMinCustomerCount) {
            return (int) (expectedMaxCustomerCount - currentCustomerCount);
        } else {
            double expectedAvgCustomerCount =
                    (expectedMinCustomerCount + expectedMaxCustomerCount) / 2d;
            return (int) (Math.round(expectedAvgCustomerCount - currentCustomerCount));
        }
    }

    @SuppressWarnings("unused")
    private int generateCustomerCountPerSecond(boolean mode) {
        if (mode == SIMPLY_CUSTOMER_LIMITATION) {
            return RandomGenerator.getRandom(MAX_CUSTOMERS_COUNT_PER_SECOND);
        } else {
            //TODO implement complexCustomerLimitation
            return 10;
        }
    }

    private Customer generateCustomer() {
        //TODO implement constant
        int customerTypeRandom = RandomGenerator.getRandom(4 - 1);
        if (customerTypeRandom < 2) {
            return new Student();
        }
        if (customerTypeRandom < 3) {
            return new Pensioner();
        }
        return new Customer();
    }

    public int getTotalCustomerCount() {
        return totalCustomerCount;
    }

    public int getCurrentCustomerCount() {
        return currentCustomerCount;
    }

    public /*synchronized*/ void decreaseCurrentCustomerCount() {
        currentCustomerCount--;
    }

    public /*synchronized*/ void increaseCurrentCustomerCount() {
        currentCustomerCount++;
        totalCustomerCount++;
    }

    public synchronized void increaseCurrentCustomerCount(int increment) {
        currentCustomerCount += increment;
        if (increment > 0) totalCustomerCount++;
    }
}
