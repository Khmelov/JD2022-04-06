package by.it.eivanova.jd02_02.service;

import by.it.eivanova.jd02_02.entity.Cashier;
import by.it.eivanova.jd02_02.entity.Customer;
import by.it.eivanova.jd02_02.entity.Manager;
import by.it.eivanova.jd02_02.entity.Shop;
import by.it.eivanova.jd02_02.service.CashierWorker;
import by.it.eivanova.jd02_02.service.CustomerWorker;
import by.it.eivanova.jd02_02.util.RandomGenerator;
import by.it.eivanova.jd02_02.util.Timer;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread {
    private final Shop shop;

    public ShopWorker(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(shop + " opened");
        int number = 0;
        List<Thread> threads = new ArrayList<>();
        Manager manager = shop.getManager();

        for (int numberCashier = 1; numberCashier < 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, shop);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }

        while (manager.shopOpened()) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int i = 0; manager.shopOpened() && i < countCustomerPerSecond; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                customerWorker.start();
                threads.add(customerWorker);
            }
            Timer.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(shop + " closed");
    }
}
