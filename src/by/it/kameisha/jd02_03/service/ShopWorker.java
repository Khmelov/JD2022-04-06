package by.it.kameisha.jd02_03.service;

import by.it.kameisha.jd02_03.entity.*;
import by.it.kameisha.jd02_03.util.RandomGenerator;
import by.it.kameisha.jd02_03.util.Timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShopWorker extends Thread {
    public static final int N_CASHIERS_THREADS = 5;
    private final Shop shop;

    public ShopWorker(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(shop + " opened");
        int number = 0;
        Manager manager = shop.getManager();
        ExecutorService threadPoolCashiers = Executors.newFixedThreadPool(N_CASHIERS_THREADS);
        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, shop);
            threadPoolCashiers.submit(cashierWorker);
        }
        threadPoolCashiers.shutdown();
        while (manager.shopOpened()) {
            int timeSecond;
            for (timeSecond = 0; timeSecond < 60; timeSecond++) {
                int countCustomersPerSecond = getCountCustomersPerSecond(timeSecond);
                for (int i = 0; manager.shopOpened() && i < countCustomersPerSecond; i++) {
                    Customer customer = createRandomCustomer(++number);
                    CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                    customerWorker.start();
                }
                System.out.println(CustomerWorker.activeCount()+"-".repeat(40)+timeSecond);
            }
            Timer.sleep(1000);
        }
        waitTermination(threadPoolCashiers);
        System.out.println(shop + " closed ");
    }

    private void waitTermination(ExecutorService threadPool) {
        try {
            do {
                Thread.onSpinWait();
            }
            while (!threadPool.awaitTermination(1, TimeUnit.SECONDS));
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
