package by.it.smirnov.jd02_01;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;
    private final Store store;

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
    }

    @Override
    public String toString() {
        return customer.toString();
    }

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " entered the " + store);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " starts to choose goods");
        int timeout = Randomizer.get(500, 2000);
        Sleeper.sleep(timeout);
        Good good = new Good("some kinda good");
        System.out.println(customer + " has already chosen his damn goods and seeks for his money and/or banking cards in his huge pocket");
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " has left the " + store);
    }
}
