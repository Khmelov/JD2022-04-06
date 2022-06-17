package by.it.smirnov.jd02_03.services;

import by.it.smirnov.jd02_03.entities.*;
import by.it.smirnov.jd02_03.entities.customer_types.Customer;
import by.it.smirnov.jd02_03.repo.PriceListRepo;
import by.it.smirnov.jd02_03.utils.Randomizer;
import by.it.smirnov.jd02_03.utils.Sleeper;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import static by.it.smirnov.jd02_03.repo.Wordings.*;
import static java.lang.System.*;

public class CashierWorker implements Runnable {

    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        out.printf(OPEN, cashier);
        Manager manager = store.getManager();
        StoreQueue storeQueue = store.getStoreQueue();
        while (true) {
            Customer customer = storeQueue.extract();
            if (Objects.nonNull(customer)) {
                out.printf(CASH_SERVE, cashier, customer);
                int timeout = Randomizer.get(2000, 5000);
                Sleeper.sleep(timeout);
                proceedPayments(customer);
                out.printf(CASH_SERVE_OFF, cashier, customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else break;
        }
        store.cashiersAtWork--;
        out.printf(CLOSE_REVENUE, cashier, new DecimalFormat(DECIMAL).format(cashier.revenue));
    }

    private void proceedPayments(Customer customer) {
        List<Good> cart = customer.shoppingCart.getShoppingCart();
        double total = 0.0;
        double price;
        StringJoiner cheque = new StringJoiner("\n");
        cheque.add(customer + CHEQUE).add(CHEQUE_DIV);
        for (Good good : cart) {
            price = PriceListRepo.priceList.get(good.getName());
            total += price;
            cheque.add(String.format(CHEQUE_POS, good.getName(), price));
        }
        cheque.add(CHEQUE_DIV).add(String.format(CHEQUE_TOTAL, new DecimalFormat(DECIMAL).format(total)))
                .add(CHEQUE_DIV);
        out.println(cheque);
        cashier.revenue += total;
    }
}
