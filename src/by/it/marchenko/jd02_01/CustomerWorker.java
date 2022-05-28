package by.it.marchenko.jd02_01;

import by.it.marchenko.jd02_01.utility.Delayer;
import by.it.marchenko.jd02_01.utility.RandomGenerator;

import static by.it.marchenko.jd02_01.CustomerConstant.*;

public class CustomerWorker extends Thread
        implements CustomerAction {

    private Printer out;
    private final Customer customer;
    private final Store store;

    public CustomerWorker(Customer customer, Store store, Printer out) {
        this.store = store;
        this.out = out;
        this.customer = customer;
    }

    //    public CustomerWorker(Customer customer) {
//        this.out = get//new Printer();
//        System.out
//        this.customer = customer;
//    }

    public void setPrinter(Printer out) {
        this.out = out;
    }

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        out.println(customer + " finished to choose goods.");
        goOut();
    }

    @Override
    public void enteredStore() {
        out.println(customer + "entered to " + store);
    }

    @Override
    public Good chooseGood() {
        int choosingTime = RandomGenerator.getRandom(MIN_CHOOSE_TIME, MAX_CHOOSE_TIME);
        Delayer.performDelay(choosingTime);
        Good good = new Good();
        String goodName = good.getName();
        out.println(customer + " chose " + goodName);
        return good;
    }

    @Override
    public void goOut() {
        out.println(customer + "leaved " + store);
    }
}
