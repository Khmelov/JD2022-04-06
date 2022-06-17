package by.it.kameisha.jd02_03.service;

import by.it.kameisha.jd02_03.entity.*;
import by.it.kameisha.jd02_03.util.RandomGenerator;
import by.it.kameisha.jd02_03.util.Timer;
import by.it.kameisha.jd02_03.interfaces.CustomerAction;
import by.it.kameisha.jd02_03.interfaces.ShoppingCardAction;

import java.util.concurrent.Semaphore;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    public static final int MAX_CUSTOMERS_CHOOSING_GOODS = 20;
    public static final int MAX_CARTS = 50;
    public static final int MIN_TIMEOUT_CHOOSE_GOOD = 500;
    public static final int MAX_TIMEOUT_CHOOSE_GOOD = 2000;
    public static final int MIN_TIMEOUT_CART = 100;
    public static final int MAX_TIMEOUT_CART = 300;
    private final Semaphore semaphoreCustomersChoosingGoods = new Semaphore(MAX_CUSTOMERS_CHOOSING_GOODS);
    private final Semaphore semaphoreCarts = new Semaphore(MAX_CARTS);
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
        try {
            semaphoreCarts.acquire();
            takeCart();
            putRandomGoodsToCart();
            goToQueue();
            goOut();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphoreCarts.release();
        }
    }

    private void putRandomGoodsToCart() {
        try {
            semaphoreCustomersChoosingGoods.acquire();
            int count = RandomGenerator.get(customer.getMinCountGoods(), customer.getMaxCountGoods());
            for (int i = 0; i < count; i++) {
                putToCart(chooseGood());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphoreCustomersChoosingGoods.release();
        }
    }

    @Override
    public void takeCart() {
        System.out.println(customer + " take a cart");
        int timeout = (int) (customer.getTimeoutFactor()
                * RandomGenerator.get(MIN_TIMEOUT_CART, MAX_TIMEOUT_CART));
        Timer.sleep(timeout);

    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to the shop " + shop);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeout = (int) (customer.getTimeoutFactor()
                * RandomGenerator.get(MIN_TIMEOUT_CHOOSE_GOOD, MAX_TIMEOUT_CHOOSE_GOOD));
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
    public void goOut() {
        Manager manager = shop.getManager();
        manager.customerOut();
        System.out.println(customer + " leaves the shop " + shop);
    }

    @Override
    public int putToCart(Good good) {
        customer.getShoppingCart().add(good);
        int timeout = (int) (customer.getTimeoutFactor()
                * RandomGenerator.get(MIN_TIMEOUT_CART, MAX_TIMEOUT_CART));
        Timer.sleep(timeout);
        System.out.println(customer + " put " + good + " to cart. In cart " + customer.getShoppingCart().size());
        return customer.getShoppingCart().size();
    }
}
