package by.it.kameisha.jd02_03.service;

import by.it.kameisha.jd02_03.entity.*;
import by.it.kameisha.jd02_03.util.RandomGenerator;
import by.it.kameisha.jd02_03.util.Timer;

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
        for (int numberCashier = 1; numberCashier < 3; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, shop);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }
        while (manager.shopOpened()) {
            for (int timeSecond = 0; timeSecond < 60; timeSecond++) {
                int countCustomersPerSecond = getCountCustomersPerSecond(timeSecond);
                for (int i = 0; manager.shopOpened() && i < countCustomersPerSecond; i++) {
                    Customer customer = createRandomCustomer(++number);
                    CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                    customerWorker.start();
                    threads.add(customerWorker);
                }
            }
            Timer.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(shop + " closed");
    }

    private int getCountCustomersPerSecond(int timeSecond) {
        int countCustomersPerSecond = 0;
        if (timeSecond < 30 && ShopWorker.activeCount() < timeSecond + 10) {
            countCustomersPerSecond = timeSecond + 10 - ShopWorker.activeCount();
        } else if (timeSecond >= 30 && ShopWorker.activeCount() < 40 + (30 - timeSecond)) {
            countCustomersPerSecond = 40 + (30 - timeSecond) - ShopWorker.activeCount();
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
