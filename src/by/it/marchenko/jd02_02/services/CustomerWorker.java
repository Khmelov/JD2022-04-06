package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.Printer;
import by.it.marchenko.jd02_02.exception.StoreException;
import by.it.marchenko.jd02_02.interfaces.CustomerAction;
import by.it.marchenko.jd02_02.interfaces.ShoppingCardAction;
import by.it.marchenko.jd02_02.models.*;
import by.it.marchenko.jd02_02.repository.GoodRepo;
import by.it.marchenko.jd02_02.repository.PriceListRepo;
import by.it.marchenko.jd02_02.repository.StockRepo;
import by.it.marchenko.jd02_02.utility.Delayer;
import by.it.marchenko.jd02_02.utility.RandomGenerator;

import java.util.Objects;

import static by.it.marchenko.jd02_02.constants.CustomerConstant.*;
import static by.it.marchenko.jd02_02.exception.StoreException.*;

public class CustomerWorker extends Thread
        implements CustomerAction, ShoppingCardAction {

    public static final String ENTERED_TO = "entered to ";
    public static final String CHOSE = "chose ";
    public static final String FINISHED_TO_CHOOSE_GOODS = "finished to choose goods";
    public static final String LEAVED = "leaved ";
    public static final String TAKE_CART = "take cart";
    public static final boolean GOOD_PRESENT = true;
    public static final String GO_TO_THE_QUEUE = "go to the queue.";
    public static final boolean ENABLE_WAITING = true;
    public static final boolean SIMPLY_CASHIER_MODE = true;
    public static final String LIVED_THE_QUEUE = "lived the queue";

    private final Printer out;
    private final Customer customer;
    private final Store store;
    private final StockRepo stockRepo;
    private final GoodRepo goodRepo;
    private final PriceListRepo priceRepo;

    private final StoreWorker storeWorker;


    private int currentCartSize;
    private int totalCartSize;
    private ShoppingCart shoppingCart;

    private Delayer delayer;
    ManagerWorker managerWorker;
    CashierPull cashierPull;

    public CustomerWorker(Customer customer, Store store,
                          GoodRepo goodRepo, StockRepo stockRepo, PriceListRepo priceRepo, Printer out,
                          StoreWorker storeWorker) {
        this.goodRepo = goodRepo;
        this.stockRepo = stockRepo;
        this.priceRepo = priceRepo;
        this.store = store;
        this.out = out;
        this.customer = customer;
        this.storeWorker = storeWorker;

        managerWorker = store.getManagerWorker();
        cashierPull = storeWorker.getCashierPull();
    }

    @Override
    public void run() {
        init();

        enteredStore();
        takeCart();
        fillCart();
        goToCashier();
        goOut();
    }

    private void init() {
        double speedDownCoefficient = customer.getSpeedDownCoefficient();
        delayer = new Delayer(speedDownCoefficient);


    }

    @Override
    public void enteredStore() {
        out.println(customer + ENTERED_TO + store);
        storeWorker.changeCustomerCurrentCount(1);
        //storeWorker.increaseTotalCustomerCount();
    }

    @Override
    public void takeCart() {
        int minCartCapacity = customer.getMinCartCapacity();
        int maxCartCapacity = customer.getMaxCartCapacity();
        totalCartSize = RandomGenerator.getRandom(minCartCapacity, maxCartCapacity);
        shoppingCart = new ShoppingCart(totalCartSize);
        int takeCartTime = RandomGenerator.getRandom(MIN_TAKE_CART_TIME, MAX_TAKE_CART_TIME);
        delayer.performDelay(takeCartTime);
        out.println(customer + TAKE_CART);
    }

    private void fillCart() {
        while (totalCartSize > currentCartSize) {
            Good currentGood = chooseGood();
            currentCartSize = putToCart(currentGood);
        }
        out.println(customer + FINISHED_TO_CHOOSE_GOODS);
    }

    @Override
    public Good chooseGood() {
        int choosingTime = RandomGenerator.getRandom(MIN_CHOOSE_TIME, MAX_CHOOSE_TIME);
        delayer.performDelay(choosingTime);
        while (true) {
            // TODO it is possible that stock is empty and not possible to choose good
            int stockSize = stockRepo.getStockSize();
            int goodID = RandomGenerator.getRandom(stockSize - 1);
            if (stockRepo.getFromStock(goodID) == GOOD_PRESENT) {
                GoodWorker goodWorker = new GoodWorker(goodRepo, stockRepo, priceRepo);
                Good good = goodWorker.findGoodFromID(goodID);
                String goodName = good.getName();
                out.println(customer + CHOSE + goodName);
                return good;
            } else if (stockRepo.getStockRepo().isEmpty()) {
                throw new StoreException("No good in stock");
            }
        }
    }

    @Override
    public int putToCart(Good good) {
        int operationTime = RandomGenerator.getRandom(MIN_PUT_CART_TIME, MAX_PUT_CART_TIME);
        delayer.performDelay(operationTime);
        if (!Objects.isNull(shoppingCart)) {
            shoppingCart.addGoodToCart(good);
        } else {
            throw new StoreException("Cart is not assigned to " + customer);
        }
        currentCartSize = shoppingCart.getSize();
        out.println(customer + "put " + good + " in the cart. Cart size: "
                + currentCartSize + "/" + totalCartSize);
        return currentCartSize;

    }

    private void goToCashier() {
        if (shoppingCart.getSize() > 0) {
            StoreQueue storeQueue = store.getStoreQueue();
            out.println(customer + GO_TO_THE_QUEUE);
            customer.setShoppingCart(shoppingCart);
            synchronized (customer.getMonitor()) {
                storeQueue.add(customer);
                storeWorker.generateCashier(storeQueue);
                //manageCashier(storeQueue);
                waitCashierOperation();
            }
            out.println(customer + LIVED_THE_QUEUE);
        } else {
            managerWorker.increaseNotServicedCustomerCount();
        }
    }

    private void waitCashierOperation() {
        customer.setWaitingEnabled(ENABLE_WAITING);
        while (customer.isWaitingEnabled()) {
            try {
                customer.wait();
            } catch (InterruptedException e) {
                throw new StoreException(WAITING_IN_QUEUE_WAS_INTERRUPTED, e);
            }
        }
    }

    @Override
    public void goOut() {
        out.println(customer + LEAVED + store);
        storeWorker.changeCustomerCurrentCount(-1);
    }

    private void manageCashier(StoreQueue storeQueue) {

        //managerWorker.getQueueCustomerCount();

        //storeWorker.getCashierPull();


        //int currentCashierCount = storeWorker.getCurrentCashierCount();
        //int currentCashierCount = managerWorker.getCurrentCashierCount();
        synchronized (storeQueue) {
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

/*
        int deltaRestCashier = deltaCashier + cashierOnWorkCount;
        if (deltaCashier >= 0) {
            for (int i = 0; i < deltaCashier; i++) {
                Cashier cashier = new Cashier();
                cashierPull.add(cashier);
                cashierPull.setCashierOnWorkCount(++cashierOnWorkCount);
                CashierWorker cashierWorker = new CashierWorker(cashier, store, delayer, out);
                cashierWorker.start();
            }
        } else {
            Cashier cashier = cashierPull.remove();
            //cashier.wait();
        }

        //Set<CashierWorker> cashierWorkerSet = new HashSet<>();
        //while (true) {
        while (totalCashierCount < 2) {
            int expectedCashierCount = storeQueue.getExpectedCashierCount(SIMPLY_CASHIER_MODE);
            if (expectedCashierCount == totalCashierCount) {
                break;
            }
            if (expectedCashierCount > totalCashierCount) {
                Cashier cashier = new Cashier();
                //storeWorker.setCurrentCashierCount(++currentCashierCount);
                CashierWorker cashierWorker = new CashierWorker(cashier, store, delayer, out);
                managerWorker.setCurrentCashierCount(++totalCashierCount);
                //cashierWorkerSet.add(cashierWorker);
                //cashierWorkerSet.
                cashierWorker.start();
            }
            // TODO remove cashierWorker after performing operation

        }
        // while (expectedCashierCount < currentCashierCount) {
        //     currentCashierCount--;
        // }
        //if (expectedCashierCount>currentCashierCount){}
        //storeQueue.

 */
    }

}
