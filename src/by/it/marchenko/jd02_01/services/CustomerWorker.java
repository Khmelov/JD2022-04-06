package by.it.marchenko.jd02_01.services;

import by.it.marchenko.jd02_01.*;
import by.it.marchenko.jd02_01.interfaces.CustomerAction;
import by.it.marchenko.jd02_01.interfaces.ShoppingCardAction;
import by.it.marchenko.jd02_01.models.Customer;
import by.it.marchenko.jd02_01.models.Good;
import by.it.marchenko.jd02_01.models.ShoppingCart;
import by.it.marchenko.jd02_01.models.Store;
import by.it.marchenko.jd02_01.repository.StockRepo;
import by.it.marchenko.jd02_01.utility.Delayer;
import by.it.marchenko.jd02_01.utility.RandomGenerator;

import static by.it.marchenko.jd02_01.constants.CustomerConstant.*;
import static by.it.marchenko.jd02_01.constants.ShoppingCartConstant.MAX_CART_CAPACITY;
import static by.it.marchenko.jd02_01.constants.ShoppingCartConstant.MIN_CART_CAPACITY;

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
    //private final GoodWorker goodWorker;
    //private final GoodRepo goodRepo;


    private int currentCartSize;
    private int totalCartSize;
    //private final Good

    public CustomerWorker(Customer customer, StockRepo stockRepo, /*GoodWorker goodWorker,*/ Store store, Printer out) {
        this.stockRepo = stockRepo;
        //this.goodWorker = goodWorker;
        this.store = store;
        this.out = out;
        this.customer = customer;
        //this.goodRepo = goodRepo;
        currentCartSize = 0;
    }


    public void setPrinter(Printer out) {
        this.out = out;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();

        currentCartSize = 0;
        while (totalCartSize > currentCartSize) {
            Good currentGood = chooseGood();
            currentCartSize = putToCart(currentGood);
            //currentCartSize++;
        }
        out.println(customer + FINISHED_TO_CHOOSE_GOODS);
        goOut();
    }

    @Override
    public void enteredStore() {
        out.println(customer + ENTERED_TO + store);
    }

    @Override
    public void takeCart() {
        totalCartSize = RandomGenerator.getRandom(MIN_CART_CAPACITY, MAX_CART_CAPACITY);
        ShoppingCart shoppingCart = new ShoppingCart(totalCartSize);
        int takeCartTime = RandomGenerator.getRandom(MIN_TAKE_CART_TIME, MAX_TAKE_CART_TIME);
        Delayer.performDelay(takeCartTime);
        out.println(customer + TAKE_CART);
    }

    @Override
    public Good chooseGood() {
        int choosingTime = RandomGenerator.getRandom(MIN_CHOOSE_TIME, MAX_CHOOSE_TIME);
        Delayer.performDelay(choosingTime);
        int goodID;
        while (true) {
            int goodIDAmount = stockRepo.getGoodIDAmount();
            goodID = RandomGenerator.getRandom(goodIDAmount - 1);
            if (stockRepo.getFromStock(goodID) == GOOD_PRESENT) {
                currentCartSize++;
                break;
            }
        }
        // TODO implement getGood(goodID)
        Good good = new Good(goodID);
        String goodName = good.getName();

        out.println(customer + CHOSE + goodName);
        return good;
    }

    @Override
    public void goOut() {
        out.println(customer + LEAVED + store);
    }

    @Override
    public int putToCart(Good good) {
        int operationTime = RandomGenerator.getRandom(MIN_PUT_CART_TIME, MAX_PUT_CART_TIME);
        Delayer.performDelay(operationTime);
        // TODO implement calling to ShoppingCart

        out.println(customer + "put " + good + " in the cart. Current cart size: " + currentCartSize);


        return currentCartSize;

    }

}
