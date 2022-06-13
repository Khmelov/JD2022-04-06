package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.models.*;
import by.it.marchenko.jd02_02.repository.*;
import by.it.marchenko.jd02_02.exception.StoreException;
import by.it.marchenko.jd02_02.utility.CustomerChecker;
import by.it.marchenko.jd02_02.utility.Delayer;
import by.it.marchenko.jd02_02.utility.RandomGenerator;
import by.it.marchenko.jd02_02.Printer;

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
    private Delayer delayer;
    private CashierPull cashierPull;

    private volatile int currentCustomerCount = 0;

    Set<Thread> storeThreadSet;
    Set<CashierWorker> cashierWorkerSet = new HashSet<>();

    public StoreWorker(StockRepo stockRepo, Store store, GoodRepo goodRepo, PriceListRepo priceRepo,
                       Printer out) {
        this.stockRepo = stockRepo;
        this.priceRepo = priceRepo;
        this.out = out;
        this.store = store;
        this.goodRepo = goodRepo;
        this.storeThreadSet = new HashSet<>();

    }

    @Override
    public void run() {
        storeInit();
        openStore();

        new CustomerChecker(this, managerWorker).start();

        workStore();
        closeStore();
    }

    private void storeInit() {
        manager = store.getManager();
        managerWorker = new ManagerWorker(manager);
        delayer = new Delayer();
        cashierPull = new CashierPull();

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

    private void workStore() {
        for (int workTime = 0; managerWorker.storeOpened(); workTime++) {
            //int customerCountPerSecond = generateCustomerCountPerSecond(SIMPLY_CUSTOMER_LIMITATION);
            int customerCountPerSecond = generateCustomerCountPerSecond(workTime);
            for (int customerCount = 0;
                 managerWorker.storeOpened() && customerCount < customerCountPerSecond;
                 customerCount++) {
                Customer customer = generateCustomer();
                CustomerWorker customerWorker = new CustomerWorker(customer, store,
                        goodRepo, stockRepo, priceRepo, out, this);
                storeThreadSet.add(customerWorker);
                managerWorker.increaseTotalCustomerCount();
                customerWorker.start();
            }
            delayer.performDelay(REAL_ONE_SECOND);
        }
        joinCustomerAndCashierThreads();
    }

    private void joinCustomerAndCashierThreads() {
        storeThreadSet.addAll(cashierWorkerSet);
        for (Thread storeThread : storeThreadSet) {
            try {
                storeThread.join();
            } catch (InterruptedException e) {
                throw new StoreException(INTERRUPTED_EXCEPTION_MESSAGE, e);
            }
        }
    }

    private void closeStore() {
        out.printf("%s%s%s%n", store, CLOSED_MESSAGE, manager);
        out.printf("Total customer count  : %3d%n", managerWorker.getTotalCustomerCount());
        // TODO investigate why notServicedCustomer here always is equal to 0
        //out.printf("Not serviced customers: %3d%n", managerWorker.getNotServicedCustomerCount());
        cashierPull.printCashiers(out);

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
            //TODO remove method if simply customer limitation will never used
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
        }
    }

    @SuppressWarnings("unused")
    public ManagerWorker getManagerWorker() {
        return managerWorker;
    }

    public CashierPull getCashierPull() {
        return cashierPull;
    }

    public void generateCashier(StoreQueue storeQueue) {
        synchronized (store.getMonitor()) {
            int expectedCashierCount = storeQueue.getExpectedCashierCount(!SIMPLY_CASHIER_MODE);

            int totalCashierCount = cashierPull.getSize();
            int deltaCashier = expectedCashierCount - totalCashierCount;

            int cashierOnWorkCount = cashierPull.getCashierOnWorkCount();
            int deltaOnWorkCashier = expectedCashierCount - cashierOnWorkCount;

            if (deltaCashier > 0) {
                //TODO notifyAll cashiers;
                cashierPull.setCashierOnWorkCount(totalCashierCount);
                //cashierPull.setOnWorkStatus(totalCashierCount, true);

                for (int i = 0; i < deltaCashier; i++) {
                    Cashier cashier = new Cashier();
                    cashierPull.add(cashier);
                    cashierPull.setCashierOnWorkCount(++cashierOnWorkCount);
                    CashierWorker cashierWorker = new CashierWorker(cashier, store, delayer, out);
                    cashierWorkerSet.add(cashierWorker);
                    //storeThreadSet.add(cashierWorker);
                    cashierWorker.start();
                }
            } else {
                cashierPull.setCashierOnWorkCount(cashierOnWorkCount + deltaOnWorkCashier);
                if (deltaOnWorkCashier > 0) {
                    //TODO notify deltaOnWork cashiers
                    //cashierPull.setOnWorkStatus(deltaOnWorkCashier, true);

                } else {
                    // TODO wait deltaOnWork cashiers
                    //cashierPull.setOnWorkStatus(deltaOnWorkCashier, false)
                }
            }
        }
    }
}
