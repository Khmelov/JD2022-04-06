package by.it.machuga.jd02_02.service;

import by.it.machuga.jd02_02.entity.*;
import by.it.machuga.jd02_02.util.Constants;
import by.it.machuga.jd02_02.util.RandomGenerator;
import by.it.machuga.jd02_02.util.Timer;

import java.util.Objects;

import static by.it.machuga.jd02_02.util.Constants.MAX_SERVICE_TIMEOUT;
import static by.it.machuga.jd02_02.util.Constants.MIN_SERVICE_TIMEOUT;

public class CashierWorker extends Thread {
    public static final String STARTED_SERVICE_MSG = "%s started %s service%n";
    public static final String FINISHED_SERVICE_MSG = "%s finished %s service%n";
    private final Cashier cashier;
    private final Store store;

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
    }
}
