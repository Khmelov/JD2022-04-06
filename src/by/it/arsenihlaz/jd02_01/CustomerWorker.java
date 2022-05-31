package by.it.arsenihlaz.jd02_01;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Shop shop;
    private ShoppingCart shoppingCart;
    private final int timeoutChoosing = RandomGenerator.get(500, 2000);
    private final int timeoutOperation = RandomGenerator.get(100, 300);

    public CustomerWorker(Customer customer, Shop shop) {
        this.customer = customer;
        this.shop = shop;
    }

    @Override
    public void run() {

        enteredStore();
        takeCart();
        int howManyGoods = RandomGenerator.get(2, 5);
        System.out.println(customer + " started choosing products");
        for (int i = 0; i < howManyGoods; i++) {
            Good good = chooseGood();
            putToCart(good);
        }
        System.out.println(customer + " finished choosing goods");
        System.out.println(customer + " in the shopping cart " + shoppingCart.size() + " goods");
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to the " + shop);
    }

    @Override
    public Good chooseGood() {
        Timer.sleep(timeoutChoosing);
        String nameGoods = PriceListRepo.getRandomGoods();
        double price = PriceListRepo.getPrice(nameGoods);
        Good good = new Good(nameGoods, price);
        System.out.println(customer + " chose a good: " + good);
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves " + shop);
    }

    @Override
    public void takeCart() {
        shoppingCart = new ShoppingCart();
        System.out.println(customer + " take the cart");
        Timer.sleep(timeoutOperation);
    }

    @Override
    public int putToCart(Good good) {
        shoppingCart.addGoods(good.getName(), good.getPrice());
        Timer.sleep(timeoutOperation);
        return shoppingCart.size();
    }
}
