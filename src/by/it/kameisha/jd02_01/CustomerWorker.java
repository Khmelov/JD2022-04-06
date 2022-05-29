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
        System.out.println();
    }

    @Override
    public Good chooseGood() {
        return null;
    }

    @Override
    public void goOut() {

    }

    @Override
    public void takeCart() {

    }

    @Override
    public int putToCart(Good good) {
        return 0;
    }
}
