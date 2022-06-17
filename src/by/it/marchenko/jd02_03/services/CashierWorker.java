package by.it.marchenko.jd02_03.services;

import by.it.marchenko.jd02_03.Printer;
import by.it.marchenko.jd02_03.models.*;
import by.it.marchenko.jd02_03.utility.Delayer;
import by.it.marchenko.jd02_03.utility.RandomGenerator;

import java.util.Objects;

import static by.it.marchenko.jd02_03.utility.CustomerChecker.*;

public class CashierWorker extends Thread {
    public static final int MIN_CASHIER_OPERATION_TIME = 2000;
    public static final int MAX_CASHIER_OPERATION_TIME = 5000;
    public static final String START_OPERATION = " start operation with ";
    public static final String FINISH_SERVICE = "finished service by ";

    private final Cashier cashier;
    private final Store store;
    private final Delayer delayer;
    private final Printer out;

    private StoreQueue storeQueue;
    private ManagerWorker managerWorker;

    public CashierWorker(Cashier cashier, Store store, Delayer delayer, Printer out) {
        this.cashier = cashier;
        this.store = store;
        this.delayer = delayer;
        this.out = out;
    }

    @Override
    public void run() {
        initCashierWorker();
        out.println(ANSI_YELLOW + cashier + " start operation in the " + store +
                ". Queue size: " + storeQueue.getSize() + ANSI_RESET);
        //System.out.println("We are here. cashiers: "+ managerWorker.storeOpened());
        while (storeQueue.getSize() > 0 /*&& managerWorker.storeOpened()*/ && cashier.isOnWork()) {
            Customer customer = storeQueue.remove();
            if (Objects.nonNull(customer)) {
                performOperation(customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaitingEnabled(false);
                    customer.notify();
                }
            } else {
                Thread.onSpinWait();
            }
        }
        out.printf("%s%s finished work. Serviced customer: %d. Not serviced by all cashiers: %d%n" +
                        "customer count in the queue: %d%n%s",
                ANSI_RED, cashier, cashier.getServicedCustomerCount(),
                managerWorker.getNotServicedCustomerCount(), storeQueue.getSize(),
                ANSI_RESET);
    }

    private void performOperation(Customer customer) {
        out.println("\t\t\t" + cashier + START_OPERATION + customer);
        int cashierOperationTime =
                RandomGenerator.getRandom(MIN_CASHIER_OPERATION_TIME, MAX_CASHIER_OPERATION_TIME);
        delayer.performDelay(cashierOperationTime);
        ShoppingCart shoppingCart = customer.getShoppingCart();
        double checkAmount = shoppingCart.calculateCheckAmount();
        double totalReceipts = cashier.getReceipts() + checkAmount;
        cashier.setReceipts(totalReceipts);
        cashier.increaseServicedCustomerCount();
        synchronized (out) {
            out.println(customer + FINISH_SERVICE + cashier + ". Total bill: " + checkAmount +
                    ".\n Total cash: " + totalReceipts +
                    ". Total customer count: " + cashier.getServicedCustomerCount() +
                    ".\n Not serviced by all cashiers: " + managerWorker.getNotServicedCustomerCount() +
                    ". Current customer in the queue: " + storeQueue.getSize());
            out.println(shoppingCart.getBill());
        }
    }

    private void initCashierWorker() {
        storeQueue = store.getStoreQueue();
        managerWorker = store.getManagerWorker();
    }
}
