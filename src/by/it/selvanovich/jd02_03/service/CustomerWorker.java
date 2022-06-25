package by.it.selvanovich.jd02_03.service;

import by.it.selvanovich.jd02_03.interfaces.CustomerAction;
import by.it.selvanovich.jd02_03.interfaces.ShoppingCardAction;
import by.it.selvanovich.jd02_03.entity.Customer;
import by.it.selvanovich.jd02_03.entity.Good;
import by.it.selvanovich.jd02_03.entity.Queue;
import by.it.selvanovich.jd02_03.entity.Shop;
import by.it.selvanovich.jd02_03.util.RandomGenerator;
import by.it.selvanovich.jd02_03.util.Timer;

public class CustomerWorker extends Thread
        implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Shop shop;

    public CustomerWorker(Customer customer, Shop shop) {
        this.customer = customer;
        this.shop = shop;
        shop.getManager().customerEnter();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        for (int i = 0; i < RandomGenerator.get(2, 5); i++) {
            putToCart(chooseGood());
        }
        goToQueue();
        goOut();
        shop.getManager().customerOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to the " + shop);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeout = RandomGenerator.get(500, 2000);
        Timer.sleep(timeout);
        Good good = new Good();
        System.out.println(customer + " choose " + good);
        System.out.println(customer + " finished to choose goods");
        return good;
    }

    @Override
    public void goToQueue() {
        Queue queue = shop.getQueue();
        synchronized (customer.getMonitor()) {
            System.out.println(customer + " go to Queue");
            queue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()) {
                try {
                    customer.wait(); //wait notify
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(customer + " leaves the Queue");
        }
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the " + shop);
    }

    @Override
    public void takeCart() {
        customer.takeCart();
        System.out.println(customer + " take a cart");
    }

    @Override
    public int putToCart(Good good) {
        int timeout = RandomGenerator.get(100, 300);
        Timer.sleep(timeout);
        customer.putToCart(good);
        System.out.println(customer + " put to cart " + customer.checkTotalGoods() + " goods");
        return customer.checkTotalGoods();
    }
}
