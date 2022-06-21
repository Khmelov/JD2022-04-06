package by.it.marchenko.jd02_03.services;

import by.it.marchenko.jd02_03.Printer;
import by.it.marchenko.jd02_03.exception.StoreException;
import by.it.marchenko.jd02_03.interfaces.CustomerAction;
import by.it.marchenko.jd02_03.interfaces.ShoppingCardAction;
import by.it.marchenko.jd02_03.models.*;
import by.it.marchenko.jd02_03.repository.GoodRepo;
import by.it.marchenko.jd02_03.repository.PriceListRepo;
import by.it.marchenko.jd02_03.repository.StockRepo;
import by.it.marchenko.jd02_03.utility.Delayer;
import by.it.marchenko.jd02_03.utility.RandomGenerator;

import java.util.Objects;
import java.util.concurrent.Semaphore;

import static by.it.marchenko.jd02_03.constants.CustomerConstant.*;
import static by.it.marchenko.jd02_03.constants.StoreExceptionConstant.WAITING_IN_QUEUE_WAS_INTERRUPTED;

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
    //public static final boolean SIMPLY_CASHIER_MODE = true;
    public static final String LIVED_THE_QUEUE = "lived the queue";
    public static final boolean RELEASE_SHOPPING_CART = false;
    public static final boolean LOCK_SHOPPING_CART = true;

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
    private Semaphore shoppingCartLimiter;

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
        shoppingCartLimiter = storeWorker.getShoppingCartLimiter();
    }

    @Override
    public void enteredStore() {
        out.println(customer + ENTERED_TO + store);
        storeWorker.changeCustomerCurrentCount(1);
    }

    @Override
    public void takeCart() {
        changeShoppingCartWaitingMode(LOCK_SHOPPING_CART);
        storeWorker.changeShoppingCartCount(-1);
        int minCartCapacity = customer.getMinCartCapacity();
        int maxCartCapacity = customer.getMaxCartCapacity();
        totalCartSize = RandomGenerator.getRandom(minCartCapacity, maxCartCapacity);
        shoppingCart = new ShoppingCart(totalCartSize);
        int takeCartTime = RandomGenerator.getRandom(MIN_TAKE_CART_TIME, MAX_TAKE_CART_TIME);
        delayer.performDelay(takeCartTime);
        out.println(customer + TAKE_CART);
    }

    private void fillCart() {
        Semaphore shoppingRoomCustomerLimiter = storeWorker.getShoppingRoomCustomerLimiter();
        while (!shoppingRoomCustomerLimiter.tryAcquire()) {
            Thread.onSpinWait();
        }
        storeWorker.changeShoppingRoomCustomerCount(1);
        while (totalCartSize > currentCartSize) {
            Good currentGood = chooseGood();
            currentCartSize = putToCart(currentGood);
        }
        shoppingRoomCustomerLimiter.release();
        storeWorker.changeShoppingRoomCustomerCount(-1);
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
                System.out.println("We are here. cashiers: " + storeWorker.getCurrentCashierCount());
                customer.wait();
            } catch (InterruptedException e) {
                throw new StoreException(WAITING_IN_QUEUE_WAS_INTERRUPTED, e);
            }
        }
    }

    @Override
    public void goOut() {
        storeWorker.changeShoppingCartCount(1);
        changeShoppingCartWaitingMode(RELEASE_SHOPPING_CART);
        out.println(customer + LEAVED + store);
        storeWorker.changeCustomerCurrentCount(-1);
    }

    private void changeShoppingCartWaitingMode(boolean waitingMode) {
        if (waitingMode) {
            while (!shoppingCartLimiter.tryAcquire()) {
                Thread.onSpinWait();
            }
        } else {
            shoppingCartLimiter.release();
        }
    }
}
