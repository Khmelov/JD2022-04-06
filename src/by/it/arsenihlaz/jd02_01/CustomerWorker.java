package by.it.arsenihlaz.jd02_01;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    // Student №[1-9]++ in the shopping cart [0-9]++ goods
    private final Customer customer;
    private final Shop shop;
    private ShoppingCart shoppingCart;
    private final int timeoutOperationPensioner = RandomGenerator.get(150, 450);
    private final int timeoutOperation = RandomGenerator.get(100, 300);


    public CustomerWorker(Customer customer, Shop shop) {
        this.customer = customer;
        this.shop = shop;
    }

    @Override
    public void run() {

        enteredStore();
        takeCart();
        System.out.println(customer + " started choosing goods");
        int howManyGoods = howManyGoods();
        if (howManyGoods == 0) {
            System.out.println(customer + " looked at the prices and decided not to take anything");
        }
        for (int i = 0; i < howManyGoods; i++) {
            Good good = chooseGood();
            putToCart(good);
        }
        System.out.println(customer + " finished choosing goods");
        System.out.println(customer + " in the shopping cart " + shoppingCart.size() + " goods");
        goOut();
    }

    private int howManyGoods() {
        String nameCustomer = String.valueOf(customer);
        int numberOfGoods;
        if (nameCustomer.contains("Student")) {
            numberOfGoods = RandomGenerator.get(0, 2);
        } else {
            numberOfGoods = RandomGenerator.get(2, 5);
        }
        return numberOfGoods;
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to the " + shop);
    }

    @Override
    public Good chooseGood() {
        String nameGoods = PriceListRepo.getRandomGoods();
        double price = PriceListRepo.getPrice(nameGoods);
        Good good = new Good(nameGoods, price);
        System.out.println(customer + " chose a good: " + good);
        timeout();
        return good;
    }

    private void timeout() {
        String nameCustomer = String.valueOf(customer);
        if (nameCustomer.contains("Pensioner")) {
            Timer.sleep(timeoutOperationPensioner);
        } else {
            Timer.sleep(timeoutOperation);
        }
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves " + shop);
    }

    @Override
    public void takeCart() {
        shoppingCart = new ShoppingCart();
        System.out.println(customer + " take the cart");
        timeout();
    }

    @Override
    public int putToCart(Good good) {
        shoppingCart.addGoods(good.getName(), good.getPrice());
        System.out.println(customer + " put the " + good.getName() + " in the cart");
        timeout();
        return shoppingCart.size();
    }
}
