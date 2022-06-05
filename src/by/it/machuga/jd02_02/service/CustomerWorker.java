package by.it.machuga.jd02_02.service;

import by.it.machuga.jd02_02.entity.*;
import by.it.machuga.jd02_02.interfaces.CustomerAction;
import by.it.machuga.jd02_02.interfaces.ShoppingCardAction;
import by.it.machuga.jd02_02.util.ChooseHelper;
import by.it.machuga.jd02_02.util.Constants;
import by.it.machuga.jd02_02.util.RandomGenerator;
import by.it.machuga.jd02_02.util.Timer;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    private final Customer customer;
    private final Store store;

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        store.getManager().customerIn();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        System.out.printf(Constants.STARTED_CHOOSE_GOODS_MSG, customer);
        int goodsQuantity = RandomGenerator.getRandomInt(customer.getMinGood(), customer.getMaxGood());
        for (int i = 0; i < goodsQuantity; i++) {
            Good good = chooseGood();
            putToCart(good);
        }
        System.out.printf(Constants.FINISHED_CHOOSE_GOODS_MSG, customer);
        goToQueue();
        goOut();
        store.getManager().customerOut();
    }

    @Override
    public void enteredStore() {
        System.out.printf(Constants.ENTERED_STORE_MSG, customer);
    }

    @Override
    public void takeCart() {
        ShoppingKart shoppingKart = new ShoppingKart();
        customer.setShoppingKart(shoppingKart);
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
    public int putToCart(Good good) {
        ShoppingKart shoppingKart = customer.getShoppingKart();
        shoppingKart.addGoodToCart(good);
        return shoppingKart.getGoodsCount();
    }

    @Override
    public void goOut() {
        System.out.printf(Constants.LEFT_STORE_MSG, customer);
    }
}
