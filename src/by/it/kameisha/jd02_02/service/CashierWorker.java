package by.it.kameisha.jd02_02.service;

import by.it.kameisha.jd02_02.entity.*;
import by.it.kameisha.jd02_02.util.RandomGenerator;
import by.it.kameisha.jd02_02.util.Timer;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

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
                    serveCustomer(customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.println(cashier + " closed. Total revenue: " + cashier.getRevenue());
    }

    private void serveCustomer(Customer customer) {
        System.out.println(cashier + " started service " + customer);
        int timeout = RandomGenerator.get(2000, 5000);
        Timer.sleep(timeout);
        int revenue = printCheck(customer);
        cashier.addRevenue(revenue);
        System.out.println(cashier + " finished service " + customer);
    }

    private int printCheck(Customer customer) {
        List<Good> shoppingCart = customer.getShoppingCart();
        Map<Good, Integer> priceList = shop.getRepository().getPriceList();
        int revenue = 0;
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(String.format("%10s print check to %10s", cashier, customer));
        for (Good good : shoppingCart) {
            for (Map.Entry<Good, Integer> entry : priceList.entrySet()) {
                if (good.toString().equals(entry.getKey().toString())) {
                    joiner.add(String.format("%15s...........%-10d", good, entry.getValue()));
                    revenue = revenue + entry.getValue();
                }
            }
        }
        joiner.add(String.format("%15s:..........%-10d", "total", revenue));
        System.out.println(joiner);
        return revenue;
    }
}
