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
                synchronized (customer.getMonitor()) {
                    System.out.println(cashier + " started service " + customer);
                    int timeout = RandomGenerator.get(2000, 5000);
                    Timer.sleep(timeout);
                    int revenue = printCheck(customer);
                    cashier.addRevenue(revenue);
                    System.out.println(cashier + " finished service " + customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.println(cashier + " closed. Total revenue: " + cashier.getRevenue());
    }

    private int printCheck(Customer customer) {
        List<Good> shoppingCart = customer.getShoppingCart();
        Map<Good, Integer> priceList = shop.getRepository().getPriceList();
        int revenue = 0;
        System.out.printf("%10s print check to %10s%n", cashier, customer);
        for (Good good : shoppingCart) {
            for (Map.Entry<Good, Integer> entry : priceList.entrySet()) {
                if (good.toString().equals(entry.getKey().toString())) {
                    System.out.printf("%15s...........%-10d%n", good, entry.getValue());
                    revenue = revenue + entry.getValue();
                }
            }
        }
        System.out.printf("%14s:...........%-10d%n", "total", revenue);
        return revenue;
    }
}
