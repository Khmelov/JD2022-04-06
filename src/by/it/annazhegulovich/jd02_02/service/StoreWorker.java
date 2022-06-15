package by.it.annazhegulovich.jd02_02.service;

import by.it.annazhegulovich.jd02_02.entity.Cashier;
import by.it.annazhegulovich.jd02_02.entity.Manager;
import by.it.annazhegulovich.jd02_02.util.RandomGenerator;
import by.it.annazhegulovich.jd02_02.util.Timer;
import by.it.annazhegulovich.jd02_02.entity.Customer;
import by.it.annazhegulovich.jd02_02.entity.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreWorker extends Thread{
    private  final Store store;


    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(store + " opened");
        int number=0;
        List<Thread> threads=new ArrayList<>();
        Manager manager = store.getManager();

        for (int numberCashier = 1; numberCashier < 2; numberCashier++) {
            Cashier cashier = new Cashier(numberCashier);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            thread.start();
        }
        while (manager.storeOpened()) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int i = 0; i < countCustomerPerSecond; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(customer, store);
                customerWorker.start();
                threads.add(customerWorker);
            }
            Timer.sleep(1000);
        }
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(store + " closed");

    }
}
