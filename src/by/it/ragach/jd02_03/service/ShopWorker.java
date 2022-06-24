package by.it.ragach.jd02_03.service;

import by.it.ragach.jd02_03.entity.*;
import by.it.ragach.jd02_03.util.RandomGenerator;
import by.it.ragach.jd02_03.util.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShopWorker extends Thread {
    public static final int N_CASHIERS_THREADS = 5;
    private final Shop shop;

    int number = 0;

    public ShopWorker(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(shop + " opened");
        Manager manager = shop.getManager();

        ExecutorService threadPoolCashiers = Executors.newFixedThreadPool(N_CASHIERS_THREADS);



        for (int numberCashier = 1; numberCashier <= 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, shop);
            threadPoolCashiers.submit(cashierWorker);

        }
        threadPoolCashiers.shutdown();


        int customerPerSecond;
        int time = 0;
        while (manager.shopOpened()) {
            int numberOfBuyers = CustomerWorker.countBuyers();
            int second = time % 60;
            if (second < 30 && numberOfBuyers <= (10 + second)) {
                customerPerSecond = RandomGenerator.get(10 + second / 2);
            } else if (second >= 30 && numberOfBuyers <= (40 + (30 - second))) {
                customerPerSecond = RandomGenerator.get(40 + (30 - second) - numberOfBuyers);
            } else customerPerSecond = 0;

            for (int i = 0; manager.shopOpened() && i < customerPerSecond; i++) {
                Customer customer = customerCreator();
                CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                customerWorker.start();


            }
            time++;
            Timer.sleep(1000);
            System.out.println("Quantity of buyers " + numberOfBuyers);
            System.out.println(second);
        }

        waitTermination(threadPoolCashiers);
        System.out.println(shop + " closed");
    }

    private void waitTermination(ExecutorService threadPool) {
        try {
            do{
                Thread.onSpinWait();
            }
            while (!threadPool.awaitTermination(10, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Customer customerCreator() {

        int customerType = RandomGenerator.get(0,99);
        Customer customer;
        if (customerType<25){
            customer = new Pensioner(++number);
        }else if (customerType>=75){
            customer = new Customer(number++);
        }else{
            customer=new Student(number++);

        }

        return customer;
    }

}
