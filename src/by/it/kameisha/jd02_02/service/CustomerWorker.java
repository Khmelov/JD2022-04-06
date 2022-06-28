package by.it.kameisha.jd02_02.service;

import by.it.kameisha.jd02_02.entity.*;
import by.it.kameisha.jd02_02.util.RandomGenerator;
import by.it.kameisha.jd02_02.util.Timer;
import by.it.kameisha.jd02_02.interfaces.CustomerAction;
import by.it.kameisha.jd02_02.interfaces.ShoppingCardAction;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
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
        int count = RandomGenerator.get(customer.getMinCountGoods(), customer.getMaxCountGoods());
        for (int i = 0; i < count; i++) {
            putToCart(chooseGood());
        }
        goToQueue();
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to the shop " + shop);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeout = (int) (customer.getTimeoutFactor() * RandomGenerator.get(500, 2000));
        Timer.sleep(timeout);
        int indexRandomGood = RandomGenerator.get(shop.getRepository().getGoodsList().size() - 1);
        Good good = new Good(shop.getRepository().getGoodsList().get(indexRandomGood));
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
            while (customer.isWaiting())
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            System.out.println(customer + " leaves the Queue");
        }
    }

    @Override
    public synchronized void goOut() {
        Manager manager = shop.getManager();
        manager.customerOut();
        System.out.println(customer + " leaves the shop " + shop);
    }

    @Override
    public void takeCart() {
        System.out.println(customer + " take a cart");
        int timeout = (int) (customer.getTimeoutFactor() * RandomGenerator.get(100, 300));
        Timer.sleep(timeout);
    }

    @Override
    public int putToCart(Good good) {
        customer.getShoppingCart().add(good);
        int timeout = (int) (customer.getTimeoutFactor() * RandomGenerator.get(100, 300));
        Timer.sleep(timeout);
        System.out.println(customer + " put " + good + " to cart. In cart " + customer.getShoppingCart().size());
        return customer.getShoppingCart().size();
    }
}
