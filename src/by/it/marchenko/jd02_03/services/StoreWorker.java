package by.it.marchenko.jd02_03.services;

import by.it.marchenko.jd02_03.Printer;
import by.it.marchenko.jd02_03.exception.StoreException;
import by.it.marchenko.jd02_03.interfaces.StoreAction;
import by.it.marchenko.jd02_03.models.*;
import by.it.marchenko.jd02_03.repository.GoodRepo;
import by.it.marchenko.jd02_03.repository.PriceListRepo;
import by.it.marchenko.jd02_03.repository.StockRepo;
import by.it.marchenko.jd02_03.utility.CustomerChecker;
import by.it.marchenko.jd02_03.utility.Delayer;
import by.it.marchenko.jd02_03.utility.RandomGenerator;
import by.it.marchenko.jd02_03.utility.StockAuditor;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static by.it.marchenko.jd02_03.constants.CustomerConstant.*;
import static by.it.marchenko.jd02_03.constants.StoreConstant.*;
import static by.it.marchenko.jd02_03.constants.StoreExceptionConstant.INTERRUPT_CASHIERS_AND_CUSTOMERS_JOINING;
import static by.it.marchenko.jd02_03.constants.StoreExceptionConstant.STOCK_WORKER_WAS_INTERRUPTED;
import static java.lang.Math.abs;
import static java.lang.Math.round;

public class StoreWorker extends Thread implements StoreAction {
    public static final int SHOPPING_ROOM_CUSTOMER_LIMIT = 20;
    private final Printer out;
    private final Store store;
    private final StockRepo stockRepo;
    private final GoodRepo goodRepo;
    private final PriceListRepo priceRepo;
    private final Semaphore shoppingRoomCustomerLimiter;
    private final AtomicInteger shoppingRoomCustomerCount;

    private Manager manager;
    private ManagerWorker managerWorker;
    private Delayer delayer;
    private CashierPull cashierPull;
    private StockAuditor auditor;
    private ExecutorService cashierExecutorService;


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
        this.shoppingRoomCustomerLimiter = new Semaphore(SHOPPING_ROOM_CUSTOMER_LIMIT);
        currentCustomerCount = 0;
        currentCashierCount = 0;
        shoppingRoomCustomerCount = new AtomicInteger(0);
    }

    public Semaphore getShoppingRoomCustomerLimiter() {
        return shoppingRoomCustomerLimiter;
    }

    @Override
    public void run() {
        storeInit();
        openStore();
        new CustomerChecker(this, managerWorker).start(); //  remove comments for enable checks
        workStore();
        closeStore();
    }

    private void storeInit() {
        manager = store.getManager();
        managerWorker = store.getManagerWorker();
        delayer = new Delayer();
        cashierPull = new CashierPull();
        StockWorker stockWorker = new StockWorker(stockRepo, goodRepo, priceRepo);
        cashierExecutorService = Executors.newCachedThreadPool();
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
                //try {
                //shoppingRoomCustomerLimiter.acquire();
                Customer customer = generateCustomer();
                CustomerWorker customerWorker = new CustomerWorker(customer, store,
                        goodRepo, stockRepo, priceRepo, out, this);
                storeThreadSet.add(customerWorker);
                managerWorker.increaseTotalCustomerCount();
                customerWorker.start();
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //} finally {
                //shoppingRoomCustomerLimiter.release();
                //}


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
        cashierExecutorService.shutdown();
        for (Thread storeThread : storeThreadSet) {
            try {
                storeThread.join();
            } catch (InterruptedException e) {
                throw new StoreException(INTERRUPT_CASHIERS_AND_CUSTOMERS_JOINING, e);
            }
        }
        boolean termination = false;
        try {
            termination = cashierExecutorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new StoreException(INTERRUPT_CASHIERS_AND_CUSTOMERS_JOINING, e);
        } finally {
            out.println("Cashiers threads correctly finished: " + termination);
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
        synchronized (store.getMonitor()) {
            currentCustomerCount += increment;
        }
    }

    @Override
    public void generateCashier(StoreQueue storeQueue) {
        synchronized (store.getMonitor()) {
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
                    //cashierExecutorService.execute(cashierWorker);
                } else if (deltaCashierCount < 0) {
                    currentCashierCount--;
                    cashierPull.lullOnWorkCashier();
                }
            }
        }
    }

    public AtomicInteger getShoppingRoomCustomerCount() {
        return shoppingRoomCustomerCount;
    }

    public void changeShoppingRoomCustomerCount(int delta) {
        shoppingRoomCustomerCount.getAndAdd(delta);
    }
}
