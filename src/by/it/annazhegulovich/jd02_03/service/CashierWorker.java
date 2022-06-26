package by.it.annazhegulovich.jd02_03.service;

import by.it.annazhegulovich.jd02_03.entity.*;
import by.it.annazhegulovich.jd02_03.util.RandomGenerator;
import by.it.annazhegulovich.jd02_03.util.Timer;

import java.util.Objects;

public class CashierWorker implements Runnable {
    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(cashier+"opened");
        Manager manager = store.getManager();
        Queue queue = store.getQueue();
        while (!manager.storeClosed()){
            Customer customer = queue.extract();
                if(Objects.nonNull(customer)){
                    System.out.println(cashier+" started service "+customer);
                    int timeout = RandomGenerator.get(2000, 5000);
                    Timer.sleep(timeout);
                    System.out.println(cashier+" finished service "+customer);
                   synchronized (customer.getMonitor()){
                       customer.setWaiting(false);
                       customer.notify();
                   }
                } else {
                    synchronized (queue){
                        try {
                            queue.wait(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

        }
        System.out.println(cashier+"closed");
    }
}
