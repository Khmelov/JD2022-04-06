package by.it.kameisha.jd02_03.service;

import by.it.kameisha.jd02_03.entity.*;
import by.it.kameisha.jd02_03.util.RandomGenerator;
import by.it.kameisha.jd02_03.util.Timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShopWorker extends Thread {
    public static final int N_CASHIERS_THREADS = 5;
    public static final int MAX_NUMBER_CASHIER = 5;
    public static final int MIN_NUMBER_CASHIER = 1;
    public static final int TIMEOUT_SLEEP = 1000;
    public static final int TIMEOUT_AWAIT_TERMINATION_SECONDS = 1;
    private final Shop shop;

    public ShopWorker(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(shop + " opened");
        ExecutorService threadPoolCashiers = Executors.newFixedThreadPool(N_CASHIERS_THREADS);
        createCashierThreads(threadPoolCashiers);
        threadPoolCashiers.shutdown();
        createCustomerWorkerPerSecond();
        waitTermination(threadPoolCashiers);
        System.out.println(shop + " closed ");
    }

    private void createCustomerWorkerPerSecond() {
        Manager manager = shop.getManager();
        int number = 0;
        while (manager.shopOpened()) {
            for (int timeSecond = 0; timeSecond < 60; timeSecond++) {
                int countCustomersPerSecond = getCountCustomersPerSecond(timeSecond);
                for (int i = 0; manager.shopOpened() && i < countCustomersPerSecond; i++) {
                    Customer customer = createRandomCustomer(++number);
                    CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                    customerWorker.start();
                }
                Timer.sleep(TIMEOUT_SLEEP);
            }
        }
    }

    private void createCashierThreads(ExecutorService threadPoolCashiers) {
        for (int numberCashier = MIN_NUMBER_CASHIER; numberCashier <= MAX_NUMBER_CASHIER; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, shop);
            threadPoolCashiers.submit(cashierWorker);
        }
    }

    private void waitTermination(ExecutorService threadPool) {
        try {
            do {
                Thread.onSpinWait();
            }
            while (!threadPool.awaitTermination(TIMEOUT_AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private int getCountCustomersPerSecond(int timeSecond) {
        int countCustomersPerSecond = 0;
        if (timeSecond < 30 && CustomerWorker.activeCount() < timeSecond + 10) {
            countCustomersPerSecond = timeSecond + 10 - CustomerWorker.activeCount();
        } else if (timeSecond >= 30 && CustomerWorker.activeCount() < 40 + (30 - timeSecond)) {
            countCustomersPerSecond = 40 + (30 - timeSecond) - CustomerWorker.activeCount();
        }
        return countCustomersPerSecond;
    }

    private Customer createRandomCustomer(int number) {
        Customer customer;
        int random = RandomGenerator.get(1, 12);
        if (random < 4) {
            customer = new Customer(number);
        } else if (random < 7) {
            customer = new Pensioner(number);
        } else {
            customer = new Student(number);
        }
        return customer;
    }
}
