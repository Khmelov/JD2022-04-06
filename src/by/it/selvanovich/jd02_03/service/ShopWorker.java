package by.it.selvanovich.jd02_03.service;

import by.it.selvanovich.jd02_03.entity.Cashier;
import by.it.selvanovich.jd02_03.entity.Customer;
import by.it.selvanovich.jd02_03.entity.Manager;
import by.it.selvanovich.jd02_03.entity.Shop;
import by.it.selvanovich.jd02_03.util.RandomGenerator;
import by.it.selvanovich.jd02_03.util.Timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ShopWorker extends Thread {
    public static final int N_CASHIERS_THREADS = 5;
    private final Shop shop;
    private final Semaphore semaphore = new Semaphore(20);

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
        try {
            semaphore.acquire();
            while (manager.shopOpened()) {
                int countCustomerPerSecond = RandomGenerator.get(2);
                for (int i = 0; manager.shopOpened() && i < countCustomerPerSecond; i++) {
                    Customer customer = new Customer(++number);
                    CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                    customerWorker.start();
                }
                Timer.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

        waitTerination(threadPoolCashiers);
        System.out.println(shop + " closed");
    }

    private void waitTerination(ExecutorService threadPool) {
        try {
            do {
                Thread.onSpinWait();
            } while (!threadPool.awaitTermination(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
