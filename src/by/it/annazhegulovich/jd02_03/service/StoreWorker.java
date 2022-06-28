package by.it.annazhegulovich.jd02_03.service;

import by.it.annazhegulovich.jd02_03.entity.Cashier;
import by.it.annazhegulovich.jd02_03.entity.Customer;
import by.it.annazhegulovich.jd02_03.entity.Manager;
import by.it.annazhegulovich.jd02_03.entity.Store;
import by.it.annazhegulovich.jd02_03.util.RandomGenerator;
import by.it.annazhegulovich.jd02_03.util.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StoreWorker extends Thread {
    private final Store store;
    public static final int N_CASHIER_THREDS = 5;


    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(store + " opened");
        int number = 0;
        Manager manager = store.getManager();

        ExecutorService threadPoolCashier = Executors.newFixedThreadPool(N_CASHIER_THREDS);
        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            threadPoolCashier.submit(cashierWorker);
        }
        threadPoolCashier.shutdown();

        while (manager.storeOpened()) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int i = 0; manager.storeOpened() && i < countCustomerPerSecond; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(customer, store);
                customerWorker.start();
            }
            Timer.sleep(1000);
        }
        waitTermination(threadPoolCashier);

        System.out.println(store + " closed");

    }

    private void waitTermination(ExecutorService threadPoolCashier) {
        try {
            do {
                Thread.onSpinWait();
            } while (!threadPoolCashier.awaitTermination(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
