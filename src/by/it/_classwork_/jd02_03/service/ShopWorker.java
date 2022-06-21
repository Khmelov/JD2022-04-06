package by.it._classwork_.jd02_03.service;

import by.it._classwork_.jd02_03.entity.Cashier;
import by.it._classwork_.jd02_03.entity.Customer;
import by.it._classwork_.jd02_03.entity.Manager;
import by.it._classwork_.jd02_03.entity.Shop;
import by.it._classwork_.jd02_03.util.RandomGenerator;
import by.it._classwork_.jd02_03.util.Timer;

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
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int i = 0; manager.shopOpened() && i < countCustomerPerSecond; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                customerWorker.start();
            }
            Timer.sleep(1000);
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
