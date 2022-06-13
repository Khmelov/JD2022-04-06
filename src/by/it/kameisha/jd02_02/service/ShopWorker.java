package by.it.kameisha.jd02_02.service;

import by.it.kameisha.jd02_02.entity.*;
import by.it.kameisha.jd02_02.repository.PriceListRepository;
import by.it.kameisha.jd02_02.util.RandomGenerator;
import by.it.kameisha.jd02_02.util.Timer;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread {
    private final Shop shop;
    private final PriceListRepository repository;

    public ShopWorker(Shop shop, PriceListRepository repository) {
        this.shop = shop;
        this.repository = repository;
    }

    @Override
    public void run() {
        System.out.println(shop + " opened");
        int number = 0;
        List<Thread> threads = new ArrayList<>();
        Manager manager = shop.getManager();
        for (int numberCashier = 1; numberCashier < 4; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, shop);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }
        while (manager.shopOpened()) {
            for (int timeSecond = 0; timeSecond < 60; timeSecond++) {
                int countCustomersPerSecond = 0;
                if (timeSecond < 30 && ShopWorker.activeCount() < timeSecond + 10) {
                    countCustomersPerSecond = timeSecond + 10 - ShopWorker.activeCount();
                } else if (timeSecond >= 30 && ShopWorker.activeCount() < 40 + (30 - timeSecond)) {
                    countCustomersPerSecond = 40 + (30 - timeSecond) - ShopWorker.activeCount();
                }
                for (int i = 0; manager.shopOpened() && i < countCustomersPerSecond; i++) {
                    Customer customer = createRandomCustomer(++number);
                    CustomerWorker customerWorker = new CustomerWorker(customer, shop, repository);
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
