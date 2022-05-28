package by.it.marchenko.jd02_01.workers;

import by.it.marchenko.jd02_01.models.Customer;
import by.it.marchenko.jd02_01.Printer;
import by.it.marchenko.jd02_01.models.Store;
import by.it.marchenko.jd02_01.exception.StoreException;
import by.it.marchenko.jd02_01.utility.Delayer;
import by.it.marchenko.jd02_01.utility.RandomGenerator;

import java.util.HashSet;
import java.util.Set;

import static by.it.marchenko.jd02_01.constants.StoreConstant.*;
import static by.it.marchenko.jd02_01.constants.StoreExceptionConstant.INTERRUPTED_EXCEPTION_MESSAGE;

public class StoreWorker extends Thread {

    private final Printer out;
    private final Store store;


    public StoreWorker(Printer out, Store store) {
        this.out = out;
        this.store = store;
    }

    @Override
    public void run() {
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
                CustomerWorker customerWorker = new CustomerWorker(customer, store, out);
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
