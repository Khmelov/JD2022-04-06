package by.it.machuga.jd02_02.service;

import by.it.machuga.jd02_02.entity.*;
import by.it.machuga.jd02_02.util.Constants;
import by.it.machuga.jd02_02.util.RandomGenerator;
import by.it.machuga.jd02_02.util.Timer;

import java.util.ArrayList;
import java.util.List;

public class StoreWorker extends Thread {

    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.printf(Constants.STORE_OPENED_MSG, store);
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            cashierWorker.start();
            threads.add(cashierWorker);
        }
        Manager manager = store.getManager();
        produceCustomers(threads, manager);
        closeStoreAfterLastCustomer(threads);
        System.out.printf(Constants.STORE_CLOSED_MSG, store);
    }

    private void produceCustomers(List<Thread> customerWorkers, Manager manager) {
        while (manager.storeOpened()) {
            for (int second = Constants.FIRST_SECOND; manager.storeOpened() && second <= Constants.LAST_SECOND; second++) {
                int maxCustomerToEnter = getMaxCustomerToEnter(second);
                if (maxCustomerToEnter > 0) {
                    createCustomer(customerWorkers, manager, maxCustomerToEnter);
                }
                Timer.sleep(Constants.TIMEOUT);
            }
        }
    }

    private void createCustomer(List<Thread> customerWorkers, Manager manager, int maxCustomerToEnter) {
        int numberCustomerPerSecond = RandomGenerator.getRandomInt(maxCustomerToEnter);
        for (int i = 0; manager.storeOpened() && i < numberCustomerPerSecond; i++) {
            Customer customer = getRandomCustomer();
            CustomerWorker customerWorker = new CustomerWorker(customer, store);
            customerWorker.start();
            customerWorkers.add(customerWorker);
        }
    }

    private int getMaxCustomerToEnter(int second) {
        int maxQuantity;
        if (second <= Constants.MIDDLE_SECOND) {
            maxQuantity = second + Constants.MIN_QUANTITY;
        } else {
            maxQuantity = Constants.MAX_QUANTITY + (Constants.MIDDLE_SECOND - second);
        }
        int maxCustomerToEnter = maxQuantity - store.getManager().getCustomerQuantity();
        return maxCustomerToEnter;
    }

    private Customer getRandomCustomer() {
        String name = RandomGenerator.getRandomText(Constants.CUSTOMER_NAME_LENGTH);
        int chance = RandomGenerator.getRandomInt(1, 4);
        switch (chance) {
            case 1:
                return new Pensioner(name);
            case 2:
                return new Customer(name);
            default:
                return new Student(name);
        }
    }

    private void closeStoreAfterLastCustomer(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
