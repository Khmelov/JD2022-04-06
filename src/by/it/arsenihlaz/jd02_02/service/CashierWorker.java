package by.it.arsenihlaz.jd02_02.service;

import by.it.arsenihlaz.jd02_02.entity.*;
import by.it.arsenihlaz.jd02_02.util.RandomGenerator;
import by.it.arsenihlaz.jd02_02.util.Timer;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Shop shop;
    private ShoppingCart shoppingCart;

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
                System.out.println(cashier + " began to serve the " + customer);
                int timeout = RandomGenerator.get(2000, 5000);
                Timer.sleep(timeout);
                double checkCost = calculationCheckCost(customer);
                cashier.setRevenue(checkCost);
                System.out.println("total check amount for the " + customer + " will be " + checkCost);
                System.out.println(cashier + " finished serving the " + customer);

                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                   throw new RuntimeException(e);
//                }
            }
        }
        System.out.println(cashier + " closed. Revenue = " + cashier.getRevenue());
    }

    private double calculationCheckCost(Customer customer) {

        ShoppingCart shoppingCart = customer.getShoppingCart();
        Map<String, Double> cart = shoppingCart.getCart();
        Set<String> nameGoods = cart.keySet();
        double sumGoodPrice = 0.0;
        for (String nameGood : nameGoods) {
            Double priceGood = cart.get(nameGood);
            System.out.println(cashier + " count check for " + customer + ": " + nameGood + " with a price " + priceGood);
            sumGoodPrice += priceGood;
        }
        return sumGoodPrice;
    }
}
