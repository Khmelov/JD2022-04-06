package by.it.arsenihlaz.jd02_02.service;

import by.it.arsenihlaz.jd02_02.entity.*;
import by.it.arsenihlaz.jd02_02.util.RandomGenerator;
import by.it.arsenihlaz.jd02_02.util.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ShopWorker extends Thread {
    private final Shop shop;
    int number = 0;
    static int numberCashier = 0;


    public ShopWorker(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(shop + " opened");
        Manager manager = shop.getManager();

        ExecutorService executorCashiers = Executors.newFixedThreadPool(5);
        for (int numberCashier = 0; numberCashier < 5; numberCashier++) {
            openCashier(executorCashiers, numberCashier);
        }
        executorCashiers.shutdown();

        int cashierNeedOpen = 0;
        while (manager.shopOpened()) {
//            int queueSize = shop.getQueue().getSize();
//            cashierNeedOpen = manager.cashierNeeded(queueSize);
//            if (cashierNeedOpen > shop.getCashierWorkerOpen().size()) {
//                while (cashierNeedOpen > shop.getCashierWorkerOpen().size()) {
//                    openCashier(executorCashiers, numberCashier);
//                    numberCashier++;
//                }
//            } else if (cashierNeedOpen < shop.getCashierWorkerOpen().size()) {
//                while (cashierNeedOpen < shop.getCashierWorkerOpen().size()) {
//                    closeCashier(numberCashier);
//                    numberCashier--;
//                }
//            }
//            System.out.println("очередь = " + queueSize);
//            cashierNeedOpen = manager.cashierNeeded(queueSize);
//            System.out.println("надо " + cashierNeedOpen);
//            System.out.println("есть " + shop.getCashierWorkerOpen().size());


            int customerPerSecond;
            int time = 0;
                int numberOfBuyers = CustomerWorker.countBuyers();
                int second = time % 60;
                if (second < 30 && numberOfBuyers <= (10 + second)) {
                    customerPerSecond = RandomGenerator.get((10 + second) / 2);
                } else if (second >= 30 && numberOfBuyers <= (40 + (30 - second))) {
                    customerPerSecond = RandomGenerator.get(40 + (30 - second) - numberOfBuyers);
                } else customerPerSecond = 0;

                for (int i = 0; manager.shopOpened() && i < customerPerSecond; i++) {
                    Customer customer = customerGenerator();
                    CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                    customerWorker.start();

                }
                time++;
                Timer.sleep(1000);
//            System.out.println("количество покупателей " + numberOfBuyers);
//            System.out.println(second);

        }
        waiting(executorCashiers);
        System.out.println(shop + " closed");
    }

    private void openCashier(ExecutorService executorCashiers, int numberCashier) {
        Cashier cashier = new Cashier(numberCashier);
        CashierWorker cashierWorker = new CashierWorker(cashier, shop);
        executorCashiers.submit(cashierWorker);
    }

    private void closeCashier(int numberCashier) {
        List<CashierWorker> cashierWorkerOpen = shop.getCashierWorkerOpen();
        CashierWorker cashierWorker = cashierWorkerOpen.get(numberCashier - 1);
        Cashier cashier = cashierWorker.getCashier();
        cashier.setOpened(false);
        cashierWorkerOpen.remove(numberCashier - 1);
        shop.setCashierWorkerOpen(cashierWorkerOpen);
    }


    private Customer customerGenerator() {
        int customerType = RandomGenerator.get(0, 99);
        Customer customer;
        if (customerType < 25) {
            customer = new Pensioner(++number);
        } else if (customerType >= 75) {
            customer = new Customer(++number);
        } else {
            customer = new Student(++number);
        }
        return customer;
    }

    private void waiting(ExecutorService executor) {
        try {
            do {
                Thread.onSpinWait();
            }
            while (!executor.awaitTermination(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//            ExecutorService executors= Executors.newFixedThreadPool(5);
//            for (int numberCashier = 0; numberCashier < 5; numberCashier++) {
//                Cashier cashier = new Cashier(numberCashier);
//                executors.execute(new CashierWorker(cashier, shop));
//            }
//            executors.shutdown();

}
