package by.it.machuga.jd02_01.service;

import by.it.machuga.jd02_01.entity.Customer;
import by.it.machuga.jd02_01.entity.Good;
import by.it.machuga.jd02_01.interfaces.CustomerAction;
import by.it.machuga.jd02_01.util.RandomGenerator;
import by.it.machuga.jd02_01.util.Timer;

public class CustomerWorker extends Thread implements CustomerAction {
    private final Customer customer;

    public CustomerWorker(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goOut();
    }

    @Override
    public String toString() {
        return customer.toString();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer+" entered the store");
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer+" started to choose goods");
        int timeout=RandomGenerator.getRandomNumber(500,2000);
        Timer.sleep(timeout);
        Good good=new Good(RandomGenerator.getRandomText(5));
        System.out.println(customer+" has chosen "+good);
        System.out.println(customer+" finished to choose goods");
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer+" left the store");
    }
}
