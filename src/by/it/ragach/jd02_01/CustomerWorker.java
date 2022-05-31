package by.it.ragach.jd02_01;

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
        System.out.println(customer + " enter to the" + shop);

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
        System.out.println(customer + " leaves to the" + shop);

    }

    @Override
    public void takeCart() {

    }

    @Override
    public int putToCart(Good good) {
        return 0;
    }
}
