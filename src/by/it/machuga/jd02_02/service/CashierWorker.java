package by.it.machuga.jd02_02.service;

import by.it.machuga.jd02_02.entity.*;
import by.it.machuga.jd02_02.util.Constants;
import by.it.machuga.jd02_02.util.RandomGenerator;
import by.it.machuga.jd02_02.util.Timer;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static by.it.machuga.jd02_02.util.Constants.*;

public class CashierWorker extends Thread {
    private final Cashier cashier;
    private final Store store;
    private static int billNumber;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.printf(Constants.CASHIER_OPENED_MSG, cashier);
        Manager manager = store.getManager();
        Queue queue = store.getQueue();
        while (!manager.storeClosed()) {
            Customer customer = queue.extract();
            if (Objects.nonNull(customer)) {
                System.out.printf(STARTED_SERVICE_MSG, cashier, customer);
                int timeOut = RandomGenerator.getRandomInt(MIN_SERVICE_TIMEOUT, MAX_SERVICE_TIMEOUT);
                Timer.sleep(timeOut);
                String bill = processShoppingCart(customer.getShoppingKart());
                printBill(bill);
                System.out.printf(FINISHED_SERVICE_MSG, cashier, customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        System.out.printf(Constants.CASHIER_CLOSED_MSG, cashier);
        printRevenue();
    }

    private void printRevenue() {
        System.out.printf("%s revenue %.2f%n", cashier, cashier.getRevenue());
    }

    private void printBill(String bill) {
        System.out.println(bill);
    }

    private String processShoppingCart(ShoppingKart shoppingKart) {
        synchronized (store) {
            billNumber++;
        }
        List<Good> goods = shoppingKart.getGoods();
        double billTotal = 0;
        StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
        stringJoiner.add(SPACE.repeat(15) + cashier + BILL + billNumber);
        for (Good good : goods) {
            double price = store.getPriceListRepo().getPrice(good);
            stringJoiner.add(SPACE.repeat(15) + String.format(BILL_LINE, good, price));
            billTotal += price;
        }
        stringJoiner.add(SPACE.repeat(15) + String.format(BILL_TOTAL, billTotal));
        incrementRevenue(billTotal);
        return stringJoiner.toString();
    }

    public void incrementRevenue(double revenue) {
        double newRevenue = cashier.getRevenue() + revenue;
        cashier.setRevenue(newRevenue);
    }
}

