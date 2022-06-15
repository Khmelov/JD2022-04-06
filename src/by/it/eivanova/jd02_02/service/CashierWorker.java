package by.it.eivanova.jd02_02.service;

import by.it.eivanova.jd02_02.entity.*;
import by.it.eivanova.jd02_02.util.RandomGenerator;
import by.it.eivanova.jd02_02.util.Timer;

import java.util.Objects;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Shop shop;

    public CashierWorker(Cashier cashier, Shop shop) {
        this.cashier = cashier;
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(cashier + " opened");
        Manager manager = shop.getManager();
        Queue queue = shop.getQueue();
        while (!manager.shopClosed()) {
            Customer customer = queue.extract();
            if (Objects.nonNull(customer)) {
                System.out.println(cashier + " started service " + customer);
                int timeout = RandomGenerator.get(2000, 5000);
                Timer.sleep(timeout);
                System.out.println(cashier + " finished service " + customer);
                synchronized (customer.getMonitor()){
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait(); //good
                try {
                    //noinspection BusyWait
                    Thread.sleep(10); //bad
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(cashier + " closed");
    }
}
