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

import java.util.List;
import java.util.StringJoiner;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Store store;
    public static int customersEntered = 0;
    public static int customersLeft = 0;

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
        System.out.println(customer + " entered the " + store);
        ++customersEntered;
    }

    @Override
    public void takeCart() {
        customer.shoppingCart = new ShoppingCart(customer, store);
        int timeout = customer.getSpeed(Randomizer.get(100, 300));
        Sleeper.sleep(timeout);
        System.out.println(customer + " takes shopping cart");
    }

    @Override
    public Good chooseGood() {
        if (goodsTaken == 0) System.out.println(customer + " starts to choose goods");
        else System.out.println(customer + " starts seeking for another gear, and for sure will find it in our store");
        int timeout = Randomizer.get(500, 2000);
        Sleeper.sleep(timeout);
        Good good = new Good(PriceListRepo.getRandomGoodName());
        System.out.println(customer + " has already chosen his damn good (" +
                good.getName() + ")");
        return good;
    }

    @Override
    public int putToCart(Good good) {
        customer.shoppingCart.getShoppingCart().add(good);
        int timeout = Randomizer.get(100, 300);
        Sleeper.sleep(timeout);
        System.out.println(customer + " put chosen good to cart");
        int goodsInCart = customer.shoppingCart.getShoppingCart().size();
        return goodsInCart;
    }

    @Override
    public void goToQueue() {
        StoreQueue storeQueue = store.getStoreQueue();
        synchronized (customer.getMonitor()) {
            System.out.println(customer + " goes to queue");
            storeQueue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()){
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(customer + " seeks for his money and/or banking cards in his huge pocket, \n" +
                                        "buys goods and leaves the queue");
        }
    }

    @Override
    public void goOut() {
        List<Good> goodsList = customer.shoppingCart.getShoppingCart();
        StringJoiner goods = new StringJoiner("\n          ");
        for (Good good : goodsList) {
            goods = goods.add(good.getName());
        }
        if (goodsTaken == 0) {
            System.out.println(customer + " bought nothing and went away very sad...");
        }
        else {
            System.out.println(customer + " leaves happy the " + store + " with " + goodsTaken + " goods:\n          "
                    + goods.toString());
        }
        ++customersLeft;
    }

    public static int getInStoreCustomers() {
        return customersEntered - customersLeft;
    }
}
