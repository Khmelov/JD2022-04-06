package by.it.smirnov.jd02_03.services;

import by.it.smirnov.jd02_03.entities.Good;
import by.it.smirnov.jd02_03.entities.ShoppingCart;
import by.it.smirnov.jd02_03.entities.Store;
import by.it.smirnov.jd02_03.entities.StoreQueue;
import by.it.smirnov.jd02_03.entities.customer_types.Customer;
import by.it.smirnov.jd02_03.interfaces.CustomerAction;
import by.it.smirnov.jd02_03.interfaces.ShoppingCardAction;
import by.it.smirnov.jd02_03.repo.PriceListRepo;
import by.it.smirnov.jd02_03.utils.Randomizer;
import by.it.smirnov.jd02_03.utils.Sleeper;

import java.util.concurrent.Semaphore;

import static by.it.smirnov.jd02_03.repo.Wordings.*;
import static java.lang.System.*;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    private final Customer customer;
    private final Store store;
    private int goodsTaken;
    private static final Semaphore semaphore = new Semaphore(20);

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
        try {
            semaphore.acquire();
            enteredStore();
            takeCart();
            int chosenGoodsNumber = customer.quantityNeed();
            for (int count = 0; count < chosenGoodsNumber; count++) {
                Good good = chooseGood();
                goodsTaken = putToCart(good);
            }
            if (chosenGoodsNumber > 0) goToQueue();
            goOut();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        store.getManager().customerOut();
    }

    @Override
    public void enteredStore() {
        out.printf(ENTER, customer, store);
    }

    @Override
    public void takeCart() {
        customer.shoppingCart = new ShoppingCart(customer, store);
        int timeout = customer.getSpeed(Randomizer.get(100, 300));
        Sleeper.sleep(timeout);
        out.printf(TAKE_CART, customer);
    }

    @Override
    public Good chooseGood() {
        if (goodsTaken == 0) out.printf(CHOOSE, customer);
        else out.printf(CHOOSE_MORE, customer);
        int timeout = Randomizer.get(500, 2000);
        Sleeper.sleep(timeout);
        Good good = new Good(PriceListRepo.getRandomGoodName());
        out.printf(CHOSEN, customer, good.getName());
        return good;
    }

    @Override
    public int putToCart(Good good) {
        customer.shoppingCart.getShoppingCart().add(good);
        int timeout = Randomizer.get(100, 300);
        Sleeper.sleep(timeout);
        out.printf(PUT, customer);
        return customer.shoppingCart.getShoppingCart().size();
    }

    @Override
    public void goToQueue() {
        StoreQueue storeQueue = store.getStoreQueue();
        try {
            synchronized (customer.getMonitor()) {
                out.printf(QUEUE_IN, customer);
                storeQueue.add(customer);
                customer.setWaiting(true);
                while (customer.isWaiting()) {
                    customer.wait();
                }
                out.printf(QUEUE_OUT, customer);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void goOut() {
        if (goodsTaken == 0) {
            out.printf(AWAY_SAD, customer);
        } else {
            out.printf(AWAY_HAPPY, customer, store, goodsTaken);
        }
    }
}
