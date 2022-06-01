package by.it.kadulin.jd02_01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    private final Customer customer;
    private final Shop shop;
    private Map<String, Double> listSelectedGoods = new HashMap<>();
    private ShoppingCart shoppingCart;

    public boolean isInShop() {
        return isInShop;
    }

    private boolean isInShop = false;

    private int countGoodsInCart = 0;
    private final List<String> namesOfPriceList = PriceListRepo.getNamesOfPriceList();

    public CustomerWorker(Customer customer, Shop shop) {
        this.customer = customer;
        this.shop = shop;

    }

    @Override
    public void run() {
        enteredStore();
        while (countGoodsInCart != customer.getCountWTB()) {
            chooseGood();
        }
        goOut();

    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to the " + shop);
        isInShop = true;
        takeCart();
//        int timeout = (int) (customer.getMltSpeedOperation() * RandomGenerator.get(100, 300));
//        Timer.sleep(timeout);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeout = (int) (customer.getMltSpeedOperation() * RandomGenerator.get(500, 2000));
        Timer.sleep(timeout);
        String chosenGoods = namesOfPriceList.get(RandomGenerator.get(namesOfPriceList.size() - 1));
        double price = PriceListRepo.getPrice(chosenGoods);
        Good good = new Good(chosenGoods, price);
        countGoodsInCart = putToCart(good);
        System.out.println(customer + " choose " + good);
        System.out.println(customer + " finished to choose goods");
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the " + shop);
        isInShop = false;
        int timeout = (int) (customer.getMltSpeedOperation() * RandomGenerator.get(100, 300));
        Timer.sleep(timeout);
    }

    @Override
    public void takeCart() {
        shoppingCart = new ShoppingCart();
        int timeout = (int) (customer.getMltSpeedOperation() * RandomGenerator.get(100, 300));
        Timer.sleep(timeout);
    }

    @Override
    public int putToCart(Good good) {
        shoppingCart.addToCart(good.getName(), good.getPrice());
//        int timeout = RandomGenerator.get(100, 300);
//        Timer.sleep(timeout);
        return shoppingCart.getAmountGoods();
    }
}
