package by.it.arsenihlaz.jd02_02.service;

import by.it.arsenihlaz.jd02_02.entity.*;
import by.it.arsenihlaz.jd02_02.util.RandomGenerator;
import by.it.arsenihlaz.jd02_02.util.Timer;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Shop shop;
    private ShoppingCart shoppingCart;

    public CashierWorker(Cashier cashier, Shop shop) {
        this.cashier = cashier;
        this.shop = shop;
    }

    private static final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
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
                    System.out.println(cashier + " finished serving the " + customer);

                    synchronized (customer.getMonitor()) {
                        customer.setWaiting(false);
                        customer.notify();
                    }
                } else {
                    Thread.onSpinWait();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

//        List<CashierWorker> cashierWorkerOpen = shop.getCashierWorkerOpen();
//        int numberCashier = shop.getCashierWorkerOpen().size();
//        cashierWorkerOpen.remove(numberCashier - 1);
//        shop.setCashierWorkerOpen(cashierWorkerOpen);

        System.out.printf("%10s closed. Revenue = %.2f\n", cashier, cashier.getRevenue());
    }

    private double calculationCheckCost(Customer customer) {
        ShoppingCart shoppingCart = customer.getShoppingCart();
        Map<String, Double> cart = shoppingCart.getCart();
        Set<String> nameGoods = cart.keySet();
        double sumGoodPrice = 0.0;
        int position = 0;
        synchronized (System.out) {
            System.out.println(cashier + " began to print check for " + customer + ":");
            System.out.println("-".repeat(25));
            for (String nameGood : nameGoods) {
                Double priceGood = cart.get(nameGood);
                System.out.printf("%2d) %-15s  %.2f\n", ++position, nameGood, priceGood);
                sumGoodPrice += priceGood;
            }
            System.out.println("-".repeat(25));
            System.out.printf("total check amount: %.2f\n", sumGoodPrice);
            System.out.println("-".repeat(25));
        }
        return sumGoodPrice;
    }

    public Cashier getCashier() {
        return cashier;
    }
}
