package by.it.machuga.jd02_03.service;

import by.it.machuga.jd02_03.entity.*;
import by.it.machuga.jd02_03.util.RandomGenerator;
import by.it.machuga.jd02_03.util.Timer;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

import static by.it.machuga.jd02_03.util.Constants.*;

public class CashierWorker extends Thread {
    private final Cashier cashier;
    private final Store store;
    private static final AtomicInteger billNumber = new AtomicInteger(0);

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.printf(CASHIER_OPENED_MSG, cashier);
        Manager manager = store.getManager();
        Queue queue = store.getQueue();
        while (!manager.storeClosed() && cashier.isOpened()) {
            Customer customer = queue.extract();
            if (Objects.nonNull(customer)) {
                System.out.printf(STARTED_SERVICE_MSG, cashier, customer);
                int timeOut = RandomGenerator.getRandomInt(MIN_SERVICE_TIMEOUT, MAX_SERVICE_TIMEOUT);
                Timer.sleep(timeOut);
                String bill = processShoppingCart(customer.getShoppingCart());
                printBill(bill);
                System.out.printf(FINISHED_SERVICE_MSG, cashier, customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            }
        }
        System.out.printf(CASHIER_CLOSED_MSG, cashier);
        printRevenue();
    }

    private String processShoppingCart(ShoppingCart shoppingCart) {
        billNumber.getAndIncrement();
        List<Good> goods = shoppingCart.getGoods();
        double billTotal = 0;
        int offset = COLUMN_SEPARATOR * cashier.getNumber() + COLUMN_WIDTH * (cashier.getNumber() - 1);
        StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
        stringJoiner.add(SPACE.repeat(offset) + cashier + BILL + billNumber);
        for (Good good : goods) {
            double price = store.getPriceListRepo().getPrice(good);
            stringJoiner.add(SPACE.repeat(offset) + String.format(BILL_LINE, good, price));
            billTotal += price;
        }
        incrementRevenue(billTotal);
        incrementTotalRevenue(billTotal);
        stringJoiner.add(SPACE.repeat(offset) + String.format(BILL_TOTAL, billTotal) + SPACE.repeat(TOTAL_OFFSET - offset)
                + String.format(QUEUE_MSG, store.getQueue().getSize()) + SPACE.repeat(COLUMN_SEPARATOR)
                + String.format(STORE_TOTAL, store, Cashier.getTotalRevenue()));
        return stringJoiner.toString();
    }

    private void printBill(String bill) {
        System.out.println(bill);
    }

    private void printRevenue() {
        System.out.printf(CASHIER_REVENUE, cashier, cashier.getRevenue());
    }

    private void incrementTotalRevenue(double billTotal) {
        double newTotalRevenue = Cashier.getTotalRevenue() + billTotal;
        Cashier.setTotalRevenue(newTotalRevenue);
    }

    public void incrementRevenue(double revenue) {
        double newRevenue = cashier.getRevenue() + revenue;
        cashier.setRevenue(newRevenue);
    }

    public Cashier getCashier() {
        return cashier;
    }
}
