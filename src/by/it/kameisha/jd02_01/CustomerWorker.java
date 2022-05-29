package by.it.kameisha.jd02_01;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    private final Customer customer;
    private final Shop shop;

    public CustomerWorker(Customer customer, Shop shop) {
        this.customer = customer;
        this.shop = shop;
    }

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to the shop " + shop);
    }

    @Override
    public Good chooseGood() {
        return null;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the shop " + shop);
    }

    @Override
    public void takeCart() {
        System.out.println(customer + " take a cart");
    }

    @Override
    public int putToCart(Good good) {
        return 0;
    }
}
