package by.it.marchenko.jd02_01.services;

import by.it.marchenko.jd02_01.*;
import by.it.marchenko.jd02_01.interfaces.CustomerAction;
import by.it.marchenko.jd02_01.interfaces.ShoppingCardAction;
import by.it.marchenko.jd02_01.models.Customer;
import by.it.marchenko.jd02_01.models.Good;
import by.it.marchenko.jd02_01.models.Store;
import by.it.marchenko.jd02_01.utility.Delayer;
import by.it.marchenko.jd02_01.utility.RandomGenerator;

import static by.it.marchenko.jd02_01.constants.CustomerConstant.*;

public class CustomerWorker extends Thread
        implements CustomerAction, ShoppingCardAction {

    public static final String ENTERED_TO = "entered to ";
    public static final String CHOSE = "chose ";
    public static final String FINISHED_TO_CHOOSE_GOODS = "finished to choose goods";
    public static final String LEAVED = "leaved ";
    public static final String TAKE_CART = "take cart";

    private Printer out;
    private final Customer customer;
    private final Store store;

    public CustomerWorker(Customer customer, Store store, Printer out) {
        this.store = store;
        this.out = out;
        this.customer = customer;
    }


    public void setPrinter(Printer out) {
        this.out = out;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        chooseGood();
        out.println(customer + FINISHED_TO_CHOOSE_GOODS);
        goOut();
    }

    @Override
    public void enteredStore() {
        out.println(customer + ENTERED_TO + store);
    }

    @Override
    public Good chooseGood() {
        int choosingTime = RandomGenerator.getRandom(MIN_CHOOSE_TIME, MAX_CHOOSE_TIME);
        Delayer.performDelay(choosingTime);
        // TODO implement GoodGenerator
        Good good = new Good();
        String goodName = good.getName();
        out.println(customer + CHOSE + goodName);
        return good;
    }

    @Override
    public void goOut() {
        out.println(customer + LEAVED + store);
    }

    @Override
    public void takeCart() {
        int takeCartTime = RandomGenerator.getRandom(MIN_TAKE_CART_TIME, MAX_TAKE_CART_TIME);
        Delayer.performDelay(takeCartTime);
        out.println(customer + TAKE_CART);
    }

    @Override
    public int putToCart(Good good) {
        return 0;
    }
}
