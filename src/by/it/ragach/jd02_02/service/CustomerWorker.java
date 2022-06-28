package by.it.ragach.jd02_02.service;

import by.it.ragach.jd02_02.entity.*;
import by.it.ragach.jd02_02.util.RandomGenerator;
import by.it.ragach.jd02_02.util.Timer;
import by.it.ragach.jd02_02.interfaces.CustomerAction;
import by.it.ragach.jd02_02.interfaces.ShoppingCardAction;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Shop shop;
    private ShoppingCart shoppingCart;

    private final static Integer incomingMonitor = 0;
    private final static Integer exitMonitor = 0;
    public static int inComingCounter = 0;
    public static int exitCounter = 0;


    public CustomerWorker(Customer customer, Shop shop) {
        this.customer = customer;
        this.shop = shop;

        synchronized (incomingMonitor) {
            inComingCounter++;
        }
        shop.getManager().customerEnter();
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        System.out.println(customer + " start to choose goods");
        int amountOfGoods = customer.numberOfGoods();
        for (int i = 0; i < amountOfGoods; i++) {
            Good good = chooseGood();
            putToCart(good);

        }

        customer.setShoppingCart(shoppingCart);
        System.out.println(customer + " stopped to choose goods");
        System.out.println(customer + " in the shopping cart " + shoppingCart.size() + " goods");
        if (amountOfGoods > 0) goToQueue();
        goOut();
        shop.getManager().customerOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to the " + shop);

    }

    @Override
    public void takeCart() {
        this.shoppingCart = new ShoppingCart(customer);
        System.out.println(customer + " take shopping cart");
        int timeout = RandomGenerator.get(100, 300);
        Timer.sleep((int) (timeout * customer.speedOfOperation()));


    }

    @Override
    public Good chooseGood() {
        String nameGoods = PriceListRepo.getGoodName();
        double price = PriceListRepo.getPrice(nameGoods);
        Good good = new Good(nameGoods, price);
        System.out.println(customer + " choose " + good);
        int timeout = RandomGenerator.get(500, 2000);
        Timer.sleep((int) (timeout * customer.speedOfOperation()));
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
                    customer.wait();// wait notify
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(customer + " left the Queue");
        }

    }

    @Override
    public void goOut() {
        System.out.println(customer + " left the " + shop);
        synchronized (exitMonitor) {
            exitCounter++;
        }

    }

    @Override
    public int putToCart(Good good) {
        shoppingCart.addGoods(good.getName(), good.getPrice());
        System.out.println(customer + " put the " + good.getName() + " in the cart");
        int timeout = RandomGenerator.get(100, 300);
        Timer.sleep((int) (timeout * customer.speedOfOperation()));
        return shoppingCart.size();

    }


    protected static int countBuyers() {
        synchronized (exitMonitor) {
            return inComingCounter - exitCounter;
        }
    }
}
