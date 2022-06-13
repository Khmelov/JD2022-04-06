package by.it.kameisha.jd02_02.service;

import by.it.kameisha.jd02_02.entity.*;
import by.it.kameisha.jd02_02.util.RandomGenerator;
import by.it.kameisha.jd02_02.util.Timer;

import java.util.List;
import java.util.Map;
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
                List<Good> shoppingCart = customer.getShoppingCart();
                Map<Good, Integer> priceList = shop.getRepository().getPriceList();
                int revenue = 0;
                for (Good good : shoppingCart) {
                    for (Map.Entry<Good, Integer> entry : priceList.entrySet()) {
                        if (good.toString().equals(entry.getKey().toString())) {
                            System.out.println(good + " " + entry.getValue());
                            revenue = revenue + entry.getValue();
                        }
                    }
                }
                System.out.println("total: " + revenue);
                cashier.addRevenue(revenue);
                System.out.println(cashier + " finished service " + customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.println(cashier + " closed. Total revenue: " + cashier.getRevenue());
    }
}
