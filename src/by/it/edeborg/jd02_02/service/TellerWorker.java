package by.it.edeborg.jd02_02.service;

import by.it.edeborg.jd02_02.util.RandomGenerator;
import by.it.edeborg.jd02_02.organization.*;
import by.it.edeborg.jd02_02.util.TimeManage;

import java.util.Objects;

public class TellerWorker implements Runnable {

    private final Teller teller;
    private final Shop shop;

    public TellerWorker(Teller cashier, Shop shop) {
        this.teller = cashier;
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(teller + " opened ");
        Manager manager = shop.getManager();
        Queue queue = shop.getQueue();
        while (!manager.shopClosed()) {
            Customer customer = queue.extract();
            if (Objects.nonNull(customer)) {
                System.out.println(teller + " started service " + customer);
                int timeout = RandomGenerator.get(2000, 5000);
                TimeManage.sleep(timeout);
                System.out.println(teller + " finished service " + customer);
                synchronized (customer.getMonitor()){
                    customer.setWaiting(false);
                    customer.notify();
                }
            }
            else
            {
                Thread.onSpinWait();
                try {
                   Thread.sleep (10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(teller + " closed ");
    }
}
