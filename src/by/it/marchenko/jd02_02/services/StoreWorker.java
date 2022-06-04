package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.Printer;
import by.it.marchenko.jd02_02.exception.StoreException;
import by.it.marchenko.jd02_02.models.*;
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

    private Manager manager;
    private ManagerWorker managerWorker;

    //    private volatile int totalCustomerCount = 0;
    private volatile int currentCustomerCount = 0;

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
        new CustomerChecker(this, managerWorker).start();

        workStore();
        closeStore();
        out.printf("Total customer count: %s%n", managerWorker.getTotalCustomerCount());
        out.printf("Current customer count: %s%n", currentCustomerCount);

    }

    private void storeInit() {
        manager = store.getManager();
        managerWorker = new ManagerWorker(this, manager);
        StockWorker stockWorker = new StockWorker(stockRepo, goodRepo, priceRepo);
        out.print(STOCK_INIT_IN_PROGRESS);
        stockWorker.start();
        while (stockWorker.isAlive()) {
            out.print(INIT_PROGRESS_INDICATOR_SYMBOL);
            new Delayer().performDelay(INIT_PROGRESS_DELAY_TIME);
        }
        out.println(STOCK_INIT_FINISHED);
    }

    private void openStore() {
        out.printf("%s%s%s%n", store, OPENED_MESSAGE, manager);
    }

    private void closeStore() {
        out.printf("%s%s%s%n", store, CLOSED_MESSAGE, manager);
    }

    private void workStore() {
        Set<CustomerWorker> customerWorkerSet = new HashSet<>();
        for (int workTime = 0; managerWorker.storeOpened(); workTime++) {
            //int customerCountPerSecond = generateCustomerCountPerSecond(SIMPLY_CUSTOMER_LIMITATION);
            int customerCountPerSecond = generateCustomerCountPerSecond(workTime);
            for (int customerCount = 0; customerCount < customerCountPerSecond; customerCount++) {
                if (managerWorker.storeClosed()) {
                    break;
                }
                Customer customer = generateCustomer();
                CustomerWorker customerWorker = new CustomerWorker(customer, store,
                        goodRepo, stockRepo, priceRepo, out, this);
                customerWorkerSet.add(customerWorker);
                managerWorker.increaseTotalCustomerCount();
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

    public int getCurrentCustomerCount() {
        return currentCustomerCount;
    }

    public void changeCustomerCurrentCount(int increment) {
        synchronized (store) {
            currentCustomerCount += increment;
            // if (increment > 0) totalCustomerCount++;
        }

    }
/*
    public void increaseTotalCustomerCount() {
        synchronized (store) {
            totalCustomerCount++;
        }
    }

    public int getTotalCustomerCount() {
        synchronized (store) {
            return totalCustomerCount;
        }
    }


 */
}
