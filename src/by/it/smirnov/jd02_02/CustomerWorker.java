package by.it.smirnov.jd02_02;

import java.util.List;
import java.util.StringJoiner;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Store store;
    private ShoppingCart shoppingCart;
    public static int customersEntered = 0;
    public static int customersLeft = 0;

    private int goodsTaken;

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        this.shoppingCart = null;
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
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered the " + store);
        ++customersEntered;
    }

    @Override
    public void takeCart() {
        this.shoppingCart = new ShoppingCart(customer, store);
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
        this.shoppingCart.getShoppingCart().add(good);
        int timeout = Randomizer.get(100, 300);
        Sleeper.sleep(timeout);
        System.out.println(customer + " put chosen good to cart");
        int goodsInCart = this.shoppingCart.getShoppingCart().size();
        return goodsInCart;
    }

    @Override
    public void goOut() {
        List<Good> goodsList = this.shoppingCart.getShoppingCart();
        StringJoiner goods = new StringJoiner("\n          ");
        for (Good good : goodsList) {
            goods = goods.add(good.getName());
        }
        if (goodsTaken == 0) {
            System.out.println(customer + " bought nothing and went away very sad...");
        }
        else {
            System.out.println(customer + " seeks for his money and/or banking cards in his huge pocket, " +
                    "buys goods and leaves happy the " + store + " with " + goodsTaken + " goods:\n          "
                    + goods.toString());
        }
        ++customersLeft;
    }

    public static int getInStoreCustomers() {
        return customersEntered - customersLeft;
    }
}
