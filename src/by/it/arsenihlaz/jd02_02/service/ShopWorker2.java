//package by.it.arsenihlaz.jd02_02.service;
//
//import by.it.arsenihlaz.jd02_02.entity.*;
//import by.it.arsenihlaz.jd02_02.util.RandomGenerator;
//import by.it.arsenihlaz.jd02_02.util.Timer;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ShopWorker2 extends Thread {
//    private final Shop shop;
//    private Queue queue;
//    int number = 0;
//
//    public ShopWorker2(Shop shop) {
//        this.shop = shop;
//    }
//
//    @Override
//    public void run() {
//        System.out.println(shop + " opened");
//        List<Thread> threads = new ArrayList<>();
//        Manager manager = shop.getManager();
//
//        int customerPerSecond;
//        int time = 0;
//        int cashierNeedOpen = 0;
//
//        while (manager.shopOpened()) {
//            int queueSize = shop.getQueue().getSize();
//
//            ExecutorService executors= Executors.newFixedThreadPool(5);
//            for (int numberCashier = 0; numberCashier < 5; numberCashier++) {
//                Cashier cashier = new Cashier(numberCashier);
//                executors.execute(new CashierWorker(cashier, shop));
//            }
//            executors.shutdown();
//
//
//
//            for (int numberCashier = 0; numberCashier < cashierNeedOpen; numberCashier++) {
//                Cashier cashier = new Cashier(numberCashier);
//                CashierWorker cashierWorker = new CashierWorker(cashier, shop);
//                Thread thread = new Thread(cashierWorker);
//                threads.add(thread);
//                thread.start();
//            }
//
//
//            int numberOfBuyers = CustomerWorker.countBuyers();
//            int second = time % 60;
//
//            if (second < 30 && numberOfBuyers <= (10 + second)) {
//                customerPerSecond = RandomGenerator.get((10 + second) / 2);
//            } else if (second >= 30 && numberOfBuyers <= (40 + (30 - second))) {
//                customerPerSecond = RandomGenerator.get(40 + (30 - second) - numberOfBuyers);
//            } else customerPerSecond = 0;
//
//            for (int i = 0; manager.shopOpened() && i < customerPerSecond; i++) {
//                Customer customer = customerGenerator();
//                CustomerWorker customerWorker = new CustomerWorker(customer, shop);
//                customerWorker.start();
//                threads.add(customerWorker);
//            }
//            time++;
//            Timer.sleep(1000);
////            System.out.println("количество покупателей " + numberOfBuyers);
////            System.out.println(second);
//        }
//
//        for (Thread thread : threads) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(shop + " closed");
//    }
//
//    private void openedCashier(List<Thread> threads, int cashierOpen) {
//        for (int numberCashier = cashierOpen; numberCashier < cashierOpen; numberCashier++) {
//            Cashier cashier = new Cashier(numberCashier);
//            CashierWorker cashierWorker = new CashierWorker(cashier, shop);
//            Thread thread = new Thread(cashierWorker);
//            threads.add(thread);
//            thread.start();
//        }
//    }
//
//    private Customer customerGenerator() {
//        int customerType = RandomGenerator.get(0, 99);
//        Customer customer;
//        if (customerType < 25) {
//            customer = new Pensioner(++number);
//        } else if (customerType >= 75) {
//            customer = new Customer(++number);
//        } else {
//            customer = new Student(++number);
//        }
//        return customer;
//    }
//
//}
