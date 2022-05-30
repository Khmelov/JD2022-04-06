package by.it.machuga.jd02_01.service;

import by.it.machuga.jd02_01.entity.Customer;
import by.it.machuga.jd02_01.entity.Good;
import by.it.machuga.jd02_01.entity.ShoppingKart;
import by.it.machuga.jd02_01.entity.Store;
import by.it.machuga.jd02_01.interfaces.CustomerAction;
import by.it.machuga.jd02_01.interfaces.ShoppingCardAction;
import by.it.machuga.jd02_01.util.ChoiseHelper;
import by.it.machuga.jd02_01.util.RandomGenerator;
import by.it.machuga.jd02_01.util.Timer;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    private final Customer customer;
    private final Store store;

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        System.out.println(customer+" started to choose goods");
        int goodsQuantity = RandomGenerator.getRandomInt(2, 5);
        for (int i = 0; i < goodsQuantity; i++) {
            Good good=chooseGood();
            putToCart(good);
        }
        System.out.println(customer+" finished to choose goods");
        goOut();
    }

    @Override
    public String toString() {
        return customer.toString();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer+" entered the store");
    }

    @Override
    public Good chooseGood() {
        int timeout=RandomGenerator.getRandomInt(100,300);
        Timer.sleep(timeout);
        Good good = ChoiseHelper.getRandomGood(store.getPriceListRepo());
        System.out.println(customer+" has chosen "+good);
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer+" left the store");
    }

    @Override
    public void takeCart() {
        ShoppingKart shoppingKart = new ShoppingKart();
        customer.setShoppingKart(shoppingKart);
    }

    @Override
    public int putToCart(Good good) {
        ShoppingKart shoppingKart = customer.getShoppingKart();
        shoppingKart.addGoodToCart(good);
        return shoppingKart.getGoodsCount();
    }
}
