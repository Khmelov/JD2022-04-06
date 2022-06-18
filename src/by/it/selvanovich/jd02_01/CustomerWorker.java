package by.it.selvanovich.jd02_01;

import java.util.ArrayList;

public class CustomerWorker extends Thread
        implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Shop shop;
    private final int minGoods;
    private final int maxGoods;
    private final ArrayList<Good> cart = new ArrayList<>();

    public CustomerWorker(Customer customer, Shop shop, int minGoods, int maxGoods) {
        this.customer = customer;
        this.shop = shop;
        this.minGoods = minGoods;
        this.maxGoods = maxGoods;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        for (int i = 0; i < RandomGenerator.get(minGoods, maxGoods); i++) {
            putToCart(chooseGood());
        }
        goOut();
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
    public void goOut() {
        System.out.println(customer + " leaves the " + shop);
    }

    @Override
    public void takeCart() {
        System.out.println(customer + " take a cart");
    }

    @Override
    public void putToCart(Good good) {
        int timeout = RandomGenerator.get(100, 300);
        Timer.sleep(timeout);
        cart.add(good);
        System.out.println(customer + " put to cart " + cart.size() + " goods");
    }
}
