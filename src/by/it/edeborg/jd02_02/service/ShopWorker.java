package by.it.edeborg.jd02_02.service;

import by.it.edeborg.jd02_02.organization.Customer;
import by.it.edeborg.jd02_02.organization.Manager;
import by.it.edeborg.jd02_02.organization.Shop;
import by.it.edeborg.jd02_02.organization.Teller;
import by.it.edeborg.jd02_02.util.RandomGenerator;
import by.it.edeborg.jd02_02.util.TimeManage;

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
        int number=0;
        List<Thread> threads = new ArrayList<>();
        Manager manager = shop.getManager();

        for (int numberTeller = 1; numberTeller < 2; numberTeller++) {
            Teller teller = new Teller(numberTeller);
            TellerWorker tellerWorker = new TellerWorker(teller, shop);
            Thread thread = new Thread(tellerWorker);
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
            TimeManage.sleep(1000);
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