package by.it.edeborg.jd02_02.service;

import by.it.edeborg.jd02_02.organization.Queue;
import by.it.edeborg.jd02_02.util.RandomGenerator;
import by.it.edeborg.jd02_02.util.TimeManage;
import by.it.edeborg.jd02_02.organization.Customer;
import by.it.edeborg.jd02_02.organization.SomethingGood;
import by.it.edeborg.jd02_02.organization.Shop;
import by.it.edeborg.jd02_02.interfaces.CustomerAction;

public class CustomerWorker extends Thread implements CustomerAction {

    private final Customer customer;
    private final Shop shop;

    public CustomerWorker(Customer customer, Shop shop) {
        this.customer = customer;
        this.shop = shop;
        shop.getManager().customerEnter();
    }

    @Override
    public void run() {
        enteredStore();
        chooseGood();
        goToQueue();
        goOut();
        shop.getManager().customerOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to " + shop);
    }

    @Override
    public SomethingGood chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeOut = RandomGenerator.get(500, 2000);
        TimeManage.sleep(timeOut);
        SomethingGood good = new SomethingGood();
        System.out.println(customer + " choose " + good);
        System.out.println(customer + " finished to choose goods");
        return good;
    }

    @Override
    public void goToQueue() {
        Queue queue = shop.getQueue();
        synchronized (customer.getMonitor()) {
            System.out.println(customer + " go to Queue");
            queue.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting())
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            System.out.println(customer + " leaves the Queue");
        }
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the " + shop);
    }
}