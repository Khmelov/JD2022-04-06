package by.it.smirnov.jd02_02.services;

import by.it.smirnov.jd02_02.entities.*;
import by.it.smirnov.jd02_02.entities.customer_types.Customer;
import by.it.smirnov.jd02_02.repo.PriceListRepo;
import by.it.smirnov.jd02_02.utils.Randomizer;
import by.it.smirnov.jd02_02.utils.Sleeper;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.StringJoiner;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(cashier + " opened");
        Manager manager = store.getManager();
        StoreQueue storeQueue = store.getStoreQueue();
        while (!manager.storeClosed()) {
            Customer customer = storeQueue.extract();
            if (Objects.nonNull(customer)) {
                System.out.println(cashier + " starts serving " + customer);
                int timeout = Randomizer.get(2000, 5000);
                Sleeper.sleep(timeout);
                proceedPayments(customer);
                System.out.println(cashier + " finished serving " + customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                //Thread.onSpinWait();
                try {
                    //noinspection BusyWait
                    Thread.sleep(10); //bad
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(cashier + " closed\n" + cashier + " revenue = " + new DecimalFormat( "###,###.##" ).format(cashier.revenue));
    }

    private void proceedPayments(Customer customer) {
        List<Good> cart = customer.shoppingCart.getShoppingCart();
        double total = 0.0;
        double price;
        StringJoiner cheque = new StringJoiner("\n");
        cheque.add(customer + "'s cheque:");
        for (Good good : cart) {
            price = PriceListRepo.priceList.get(good.getName());
            total += price;
            cheque.add(String.format(Locale.ENGLISH,"          %s - %-7.2f", good.getName(), price));
        }
        cheque.add("          ==========").add("          TOTAL: " + total);
        System.out.println(cheque);
        cashier.revenue += total;
    }
}
