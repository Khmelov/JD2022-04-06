package by.it.selvanovich.jd02_03.service;

import by.it.selvanovich.jd02_03.entity.*;
import by.it.selvanovich.jd02_03.util.RandomGenerator;
import by.it.selvanovich.jd02_03.util.Timer;

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
                System.out.println();
                customer.showCart();
                cashier.addGain(customer.checkTotalPrice());
                cashier.addGoods(customer.checkTotalGoods());
                System.out.println(cashier + " finished service " + customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                synchronized (queue) {
                    try {
                        queue.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(cashier + " closed. Gain: " + cashier.getTotalGain() + "BYN, goods sold: " + cashier.getTotalGoods());
    }
}
