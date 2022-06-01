package by.it.avramchuk.jd02_01;

import java.util.Set;

public class CustomerWorker extends Thread
implements CustomerAction, ShoppingCardAction{

    private final Customer customer;
    private final Shop shop;
    private ShoppingCart myCart;

    public CustomerWorker(Customer customer, Shop shop) {
        this.customer = customer;
        this.shop = shop;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int goodsMayToBuy= customer.mayToBuy();
        System.out.println(customer+" starts to choose goods");
        for (int i = 0; i < goodsMayToBuy; i++) {
            Good nextGood = chooseGood();
            putToCart(nextGood);
        }
        System.out.println(customer+" finished. He choosed "+myCart.goodsInCart.size()+" goods");
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer+" enter to the "+shop);
    }

    @Override
    public Good chooseGood() {
        int timeout = RandomGenerator.get(500, 2000) * customer.getSpeedFactor();
        Timer.sleep(timeout);
        Set<String> goodList = PriceListRepository.priceList.keySet();
        String[] strings = goodList.toArray(String[]::new);
        int randomIndex = RandomGenerator.get(strings.length-1);
        Good good = new Good(strings[randomIndex]);
        System.out.println(customer+" choosed "+good);
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer+" leaves the "+shop);
    }

    @Override
    public void takeCart() {
        int timeout = RandomGenerator.get(100,300) * customer.getSpeedFactor();
        Timer.sleep(timeout);
        myCart = new ShoppingCart();
        System.out.println(customer+" took the cart");
    }

    @Override
    public int putToCart(Good good) {
        int timeout = RandomGenerator.get(100,300) * customer.getSpeedFactor();
        Timer.sleep(timeout);
        System.out.println(customer+" put "+good+ " to his cart");
        return myCart.addGoodToCart(good);
    }
}
