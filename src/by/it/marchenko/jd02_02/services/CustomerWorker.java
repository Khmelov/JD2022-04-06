package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.Printer;
import by.it.marchenko.jd02_02.exception.StoreException;
import by.it.marchenko.jd02_02.interfaces.CustomerAction;
import by.it.marchenko.jd02_02.interfaces.ShoppingCardAction;
import by.it.marchenko.jd02_02.models.Customer;
import by.it.marchenko.jd02_02.models.Good;
import by.it.marchenko.jd02_02.models.ShoppingCart;
import by.it.marchenko.jd02_02.models.Store;
import by.it.marchenko.jd02_02.repository.GoodRepo;
import by.it.marchenko.jd02_02.repository.PriceListRepo;
import by.it.marchenko.jd02_02.repository.StockRepo;
import by.it.marchenko.jd02_02.utility.Delayer;
import by.it.marchenko.jd02_02.utility.RandomGenerator;

import java.util.Objects;

import static by.it.marchenko.jd02_02.constants.CustomerConstant.*;

public class CustomerWorker extends Thread
        implements CustomerAction, ShoppingCardAction {

    public static final String ENTERED_TO = "entered to ";
    public static final String CHOSE = "chose ";
    public static final String FINISHED_TO_CHOOSE_GOODS = "finished to choose goods";
    public static final String LEAVED = "leaved ";
    public static final String TAKE_CART = "take cart";
    public static final boolean GOOD_PRESENT = true;

    private Printer out;
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
    }

    public void setPrinter(Printer out) {
        this.out = out;
    }

    @Override
    public void run() {
        double speedUpCoefficient = customer.getSpeedDownCoefficient();
        delayer = new Delayer(speedUpCoefficient);
        enteredStore();
        //store
        takeCart();
        while (totalCartSize > currentCartSize) {
            Good currentGood = chooseGood();
            currentCartSize = putToCart(currentGood);
        }
        out.println(customer + FINISHED_TO_CHOOSE_GOODS);
        goOut();
    }

    @Override
    public void enteredStore() {
        out.println(customer + ENTERED_TO + store);
        storeWorker.increaseCurrentCustomerCount();
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

    @Override
    public Good chooseGood() {
        int choosingTime = RandomGenerator.getRandom(MIN_CHOOSE_TIME, MAX_CHOOSE_TIME);
        delayer.performDelay(choosingTime);
        while (true) {
            // TODO it is possible that stock is empty and not possible to choose good
            int goodIDAmount = stockRepo.getGoodIDAmount();
            int goodID = RandomGenerator.getRandom(goodIDAmount - 1);
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
        // TODO implement calling to ShoppingCart

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

    @Override
    public void goOut() {
        out.println(customer + LEAVED + store);
        storeWorker.decreaseCurrentCustomerCount();
    }

}
