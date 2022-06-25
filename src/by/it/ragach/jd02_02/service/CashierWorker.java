package by.it.ragach.jd02_02.service;


import by.it.ragach.jd02_02.entity.*;
import by.it.ragach.jd02_02.util.RandomGenerator;
import by.it.ragach.jd02_02.util.Timer;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
                double checkCost = printCheckCost(customer);
                cashier.setRevenue(checkCost);
                System.out.println(cashier + " finished service " + customer);


                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                    Thread.onSpinWait();
            }
        }
        System.out.printf("%10s closed. Revenue = %.2f\n", cashier, cashier.getRevenue());
    }

    private double printCheckCost(Customer customer) {
        ShoppingCart shoppingCart = customer.getShoppingCart();
        Map<String, Double> cart = shoppingCart.getCart();
        Set<String> nameGoods = cart.keySet();
        double sumGoodPrice = 0.0;
        int position = 0;
        synchronized (System.out) {
            System.out.println(cashier + " start to print check for " + customer + ":");

            System.out.println("-".repeat(26));
            for (String nameGood : nameGoods) {
                Double priceGood = cart.get(nameGood);
                System.out.printf("%2d. %-15s  %.2f\n", ++position, nameGood, priceGood);
                sumGoodPrice += priceGood;
            }
            System.out.println("-".repeat(26));
            System.out.printf(" Total:              %.2f\n", sumGoodPrice);
            System.out.println("-".repeat(26));

        }
        return sumGoodPrice;
    }


}
