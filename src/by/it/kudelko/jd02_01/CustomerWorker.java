package by.it.kudelko.jd02_01;

public class CustomerWorker extends Thread implements CustomerAction{

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
        System.out.println(customer+" enter to "+shop);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer+" started to choose goods");
        int timeOut = RandomGenerator.get(500, 2000);
        Timer.sleep(timeOut);
        Good good = new Good();
        System.out.println(customer+" choose "+good);
        System.out.println(customer+" finished to choose goods");
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer+" leaves the "+shop);
    }
}
