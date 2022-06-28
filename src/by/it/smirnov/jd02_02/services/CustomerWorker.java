package by.it.smirnov.jd02_02.services;

import by.it.smirnov.jd02_02.entities.Good;
import by.it.smirnov.jd02_02.entities.ShoppingCart;
import by.it.smirnov.jd02_02.entities.Store;
import by.it.smirnov.jd02_02.entities.StoreQueue;
import by.it.smirnov.jd02_02.entities.customer_types.Customer;
import by.it.smirnov.jd02_02.interfaces.CustomerAction;
import by.it.smirnov.jd02_02.interfaces.ShoppingCardAction;
import by.it.smirnov.jd02_02.repo.PriceListRepo;
import by.it.smirnov.jd02_02.utils.Randomizer;
import by.it.smirnov.jd02_02.utils.Sleeper;

import static by.it.smirnov.jd02_02.repo.Wordings.*;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    private final Customer customer;
    private final Store store;
    private int goodsTaken;

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        store.getManager().customerIn();
    }

    @Override
    public String toString() {
        return customer.toString();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int chosenGoodsNumber = customer.quantityNeed();
        for (int count = 0; count < chosenGoodsNumber; count++) {
            Good good = chooseGood();
            goodsTaken = putToCart(good);
        }
        if (chosenGoodsNumber>0) goToQueue();
        goOut();
        store.getManager().customerOut();
    }

    @Override
    public void enteredStore() {
        System.out.printf(ENTER, customer, store);
    }

    @Override
    public void takeCart() {
        customer.shoppingCart = new ShoppingCart(customer, store);
        int timeout = customer.getSpeed(Randomizer.get(100, 300));
        Sleeper.sleep(timeout);
        System.out.printf(TAKE_CART, customer);
    }

    @Override
    public Good chooseGood() {
        if (goodsTaken == 0) System.out.printf(CHOOSE, customer);
        else System.out.printf(CHOOSE_MORE, customer);
        int timeout = Randomizer.get(500, 2000);
        Sleeper.sleep(timeout);
        Good good = new Good(PriceListRepo.getRandomGoodName());
        System.out.printf(CHOSEN, customer, good.getName());
        return good;
    }

    @Override
    public int putToCart(Good good) {
        customer.shoppingCart.getShoppingCart().add(good);
        int timeout = Randomizer.get(100, 300);
        Sleeper.sleep(timeout);
        System.out.printf(PUT, customer);
        int goodsInCart = customer.shoppingCart.getShoppingCart().size();
        return goodsInCart;
    }

    @Override
    public void goToQueue() {
        StoreQueue storeQueue = store.getStoreQueue();
        synchronized (customer.getMonitor()) {
            System.out.printf(QUEUE_IN, customer);
            storeQueue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()){
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.printf(QUEUE_OUT, customer);
        }
    }

    @Override
    public void goOut() {
        if (goodsTaken == 0) {
            System.out.printf(AWAY_SAD, customer);
        }
        else {
            System.out.printf(AWAY_HAPPY, customer, store, goodsTaken);
        }
    }
}
