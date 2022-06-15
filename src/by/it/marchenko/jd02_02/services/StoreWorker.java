package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.interfaces.StoreAction;
import by.it.marchenko.jd02_02.models.*;
import by.it.marchenko.jd02_02.repository.*;
import by.it.marchenko.jd02_02.exception.StoreException;
import by.it.marchenko.jd02_02.utility.Delayer;
import by.it.marchenko.jd02_02.utility.RandomGenerator;
import by.it.marchenko.jd02_02.utility.StockAuditor;
import by.it.marchenko.jd02_02.Printer;
import by.it.marchenko.jd02_02.utility.CustomerChecker;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.*;
import static by.it.marchenko.jd02_02.constants.CustomerConstant.*;
import static by.it.marchenko.jd02_02.constants.StoreConstant.*;
import static by.it.marchenko.jd02_02.constants.StoreExceptionConstant.*;

public class StoreWorker extends Thread implements StoreAction {
    private final Printer out;
    private final Store store;
    private final StockRepo stockRepo;
    private final GoodRepo goodRepo;
    private final PriceListRepo priceRepo;

    private Manager manager;
    private ManagerWorker managerWorker;
    private Delayer delayer;
    private CashierPull cashierPull;
    private StockAuditor auditor;

    private volatile int currentCustomerCount;
    private volatile int currentCashierCount;

    double initialBalance;
    double finalBalance;
    Set<CashierWorker> cashierWorkerSet;
    Set<Thread> storeThreadSet;

    public StoreWorker(Store store, StockRepo stockRepo, GoodRepo goodRepo, PriceListRepo priceRepo,
                       Printer out) {
        this.stockRepo = stockRepo;
        this.priceRepo = priceRepo;
        this.out = out;
        this.store = store;
        this.goodRepo = goodRepo;
        this.storeThreadSet = new HashSet<>();
        this.cashierWorkerSet = new HashSet<>();
        currentCustomerCount = 0;
        currentCashierCount = 0;
    }

    @Override
    public void run() {
        storeInit();
        openStore();
        //new CustomerChecker(this, managerWorker).start(); //  remove comments for enable checks
        workStore();
        closeStore();
    }

    private void storeInit() {
        manager = store.getManager();
        managerWorker = store.getManagerWorker();
        delayer = new Delayer();
        cashierPull = new CashierPull();
        StockWorker stockWorker = new StockWorker(stockRepo, goodRepo, priceRepo);

        out.print(STOCK_INIT_IN_PROGRESS);
        stockWorker.start();
        waitStockInit(stockWorker);
        out.println(STOCK_INIT_FINISHED);
    }

    private void waitStockInit(StockWorker stockWorker) {
        try {
            stockWorker.join();
        } catch (InterruptedException e) {
            throw new StoreException(STOCK_WORKER_WAS_INTERRUPTED, e);
        }
    }

    private void openStore() {
        auditor = new StockAuditor(stockRepo, priceRepo);
        initialBalance = auditor.checkStockBalance();
        out.printf(OPEN_STORE_FORMAT, store, OPENED_MESSAGE, manager);
    }

    private void workStore() {
        for (int workTime = 0; managerWorker.storeOpened(); workTime++) {
            int customerCountPerSecond = getCustomerCountPerSecond(workTime);
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

    private int getCustomerCountPerSecond(int workTime) {
        if (manager.getCustomerLimitationMode() == SIMPLY_CUSTOMER_LIMITATION) {
            return generateCustomerCountPerSecond();
        } else {
            return generateCustomerCountPerSecond(workTime);
        }
    }

    private int generateCustomerCountPerSecond() {
        return RandomGenerator.getRandom(MAX_CUSTOMERS_COUNT_PER_SECOND);
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
            return (int) (round(expectedAvgCustomerCount - currentCustomerCount));
        }
    }

    private Customer generateCustomer() {
        int customerTypeRandom = RandomGenerator.getRandom(MAX_PROBABILITY - 1);
        if (customerTypeRandom < STUDENT_PROBABILITY) {
            return new Student();
        }
        if (customerTypeRandom < (STUDENT_PROBABILITY + PENSIONER_PROBABILITY)) {
            return new Pensioner();
        }
        return new Customer();
    }

    private void joinCustomerAndCashierThreads() {
        storeThreadSet.addAll(cashierWorkerSet);
        for (Thread storeThread : storeThreadSet) {
            try {
                storeThread.join();
            } catch (InterruptedException e) {
                throw new StoreException(INTERRUPT_CASHIERS_AND_CUSTOMERS_JOINING, e);
            }
        }
    }

    private void closeStore() {
        out.printf("%s%s%s%n", store, CLOSED_MESSAGE, manager);
        out.print(cashierPull);
        out.printf("Not serviced customers: %52d%n", managerWorker.getNotServicedCustomerCount());
        out.printf("Total customer count  : %52d%n", managerWorker.getTotalCustomerCount());
        finalBalance = auditor.checkStockBalance();
        out.printf("Stock initial balance: %20.2f $%n", initialBalance);
        out.printf("Stock final balance  : %20.2f $%n", finalBalance);
        out.printf("Stock difference     : %20.2f $%n", initialBalance - finalBalance);
    }

    @Override
    public int getCurrentCustomerCount() {
        return currentCustomerCount;
    }

    @Override
    public int getCurrentCashierCount() {
        return currentCashierCount;
    }

    @Override
    public CashierPull getCashierPull() {
        return cashierPull;
    }

    @Override
    public Store getStore() {
        return store;
    }

    @Override
    public void changeCustomerCurrentCount(int increment) {
        synchronized (store) {
            currentCustomerCount += increment;
        }
    }

    @Override
    public synchronized void generateCashier(StoreQueue storeQueue) {
        //synchronized (store.getMonitor()) {
        int expectedCashierCount = storeQueue.calcExpectedCashierCount(!SIMPLY_CASHIER_MODE);
        int deltaCashierCount = expectedCashierCount - currentCashierCount;
        for (int i = 0, n = abs(deltaCashierCount); i < n; i++) {
            Cashier cashier;
            if (deltaCashierCount > 0) {
                int totalCashierCount = cashierPull.getSize();
                if (totalCashierCount <= currentCashierCount) {
                    cashier = new Cashier();
                    cashierPull.add(cashier);
                } else {
                    cashier = cashierPull.notifyOnSleepCashier();
                }
                CashierWorker cashierWorker = new CashierWorker(cashier, store, delayer, out);
                cashierWorkerSet.add(cashierWorker);
                currentCashierCount++;
                cashierWorker.start();
            } else if (deltaCashierCount < 0) {
                currentCashierCount--;
                cashierPull.lullOnWorkCashier();
            }
        }
        //}
    }
}
