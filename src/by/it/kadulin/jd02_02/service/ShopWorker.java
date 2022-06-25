package by.it.kadulin.jd02_02.service;


import by.it.kadulin.jd02_02.entity.*;
import by.it.kadulin.jd02_02.repository.PriceListRepo;
import by.it.kadulin.jd02_02.util.RandomGenerator;
import by.it.kadulin.jd02_02.util.Timer;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread {
//    public static final int TIME_WORK = 120;
    private final Shop shop;
    private static PriceListRepo priceListRepo = new PriceListRepo();

    private boolean markPensioner = false;

    public ShopWorker(Shop shop) {
        this.shop = shop;
    }


    @Override
    public void run() {
        System.out.println(shop + " opened");
        List<Thread> threadsList = new ArrayList<>();
        Manager manager = shop.getManager();

        for (int i = 1; i < 6; i++) {
            Cashier cashier = new Cashier(i);
            CashierWorker cashierWorker = new CashierWorker(cashier, shop);
            cashierWorker.start();
            threadsList.add(cashierWorker);
        }

        while (manager.isShopOpened()) {
            long second = manager.getCurrentTimeOfWork() % 60;
            if (second <= 29) {
                while (threadsList.size() <= (second + 10)) {
                    addCustomers(threadsList, manager);
                    if (!manager.isShopOpened()) {
                        break;
                    }
                }
            } else if (second > 30) {
                while (threadsList.size() <= (40 + (30 - second))) {
                    addCustomers(threadsList, manager);
                    if (!manager.isShopOpened()) {
                        break;
                    }
                }
            }
            threadsList.removeIf(customerWorker -> customerWorker.getState() == State.TERMINATED);
            Timer.sleep(1000);

        }


        for (Thread customerWorker : threadsList) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        try {
//            cashierThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        manager.setShopOpened(false);

        System.out.println(shop + " closed");
    }

    private void addCustomers(List<Thread> customerWorkerList, Manager manager) {
        Buyer buyer = null;
        int i = RandomGenerator.get(99);
        if (i <= 24) {
            buyer = new Pensioner(manager.getCountIn(), "Pensioner");
        } else if (i >= 25 && i <= 74) {
            buyer = new Student(manager.getCountIn(), "Student");
        } else if (i >= 75) {
            buyer = new Customer(manager.getCountIn(), "Customer");
        }


        BuyerWorker buyerWorker = new BuyerWorker(buyer, shop);
        manager.buyerEnter();
        buyerWorker.start();
        customerWorkerList.add(buyerWorker);
        if (manager.getPlan() == manager.getCountIn()) {
            manager.setShopOpened(false);
        }

    }
}
