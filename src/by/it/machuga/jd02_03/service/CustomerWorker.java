package by.it.machuga.jd02_03.service;

import by.it.machuga.jd02_03.entity.*;
import by.it.machuga.jd02_03.interfaces.CustomerAction;
import by.it.machuga.jd02_03.interfaces.ShoppingCartAction;
import by.it.machuga.jd02_03.util.ChooseHelper;
import by.it.machuga.jd02_03.util.Constants;
import by.it.machuga.jd02_03.util.RandomGenerator;
import by.it.machuga.jd02_03.util.Timer;

import java.util.concurrent.Semaphore;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCartAction {
    private final Customer customer;
    private final Store store;
    private static final Semaphore choiceSemaphore = new Semaphore(20);
    private static final Semaphore shoppingCartSemaphore = new Semaphore(50);

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        store.getManager().customerIn();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        chooseGoods();
        if (customer.getShoppingCart().getGoodsCount() > 0) {
            goToQueue();
        }
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.printf(Constants.ENTERED_STORE_MSG, customer);
    }

    @Override
    public void takeCart() {
        try {
            shoppingCartSemaphore.acquire();
            ShoppingCart shoppingCart = new ShoppingCart();
            customer.setShoppingCart(shoppingCart);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            shoppingCartSemaphore.release();
        }
    }

    private void chooseGoods() {
        try {
            choiceSemaphore.acquire();
            System.out.printf(Constants.STARTED_CHOOSE_GOODS_MSG, customer);
            int goodsQuantity = RandomGenerator.getRandomInt(customer.getMinGood(), customer.getMaxGood());
            for (int i = 0; i < goodsQuantity; i++) {
                Good good = chooseGood();
                putToCart(good);
            }
            System.out.printf(Constants.FINISHED_CHOOSE_GOODS_MSG, customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            choiceSemaphore.release();
        }
    }

    @Override
    public Good chooseGood() {
        int timeout = RandomGenerator.getRandomInt((int) (Constants.MIN_SELECTION_SPEED * customer.getSelectionSpeed()),
                (int) (Constants.MAX_SELECTION_SPEED * customer.getSelectionSpeed()));
        Timer.sleep(timeout);
        Good good = ChooseHelper.getRandomGood(store.getPriceListRepo());
        System.out.printf(Constants.CHOSEN_GOOD_MSG, customer, good);
        return good;
    }

    @Override
    public int putToCart(Good good) {
        ShoppingCart shoppingCart = customer.getShoppingCart();
        shoppingCart.addGoodToCart(good);
        return shoppingCart.getGoodsCount();
    }

    @Override
    public void goToQueue() {
        Queue queue = store.getQueue();
        synchronized (customer.getMonitor()) {
            System.out.printf(Constants.GOES_TO_QUEUE_MSG, customer);
            queue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting()) {
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.printf(Constants.LEFT_QUEUE_MSG, customer);
        }
    }

    @Override
    public void goOut() {
        System.out.printf(Constants.LEFT_STORE_MSG, customer);
        store.getManager().customerOut();
    }
}
