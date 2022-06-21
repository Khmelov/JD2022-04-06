package by.it.machuga.jd02_01.service;

import by.it.machuga.jd02_01.entity.Customer;
import by.it.machuga.jd02_01.entity.Pensioner;
import by.it.machuga.jd02_01.entity.Store;
import by.it.machuga.jd02_01.entity.Student;
import by.it.machuga.jd02_01.util.Constants;
import by.it.machuga.jd02_01.util.RandomGenerator;
import by.it.machuga.jd02_01.util.Timer;

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
        List<CustomerWorker> customerWorkers = new ArrayList<>();
        produceCustomers(customerWorkers);
        closeStoreAfterLastCustomer(customerWorkers);
        System.out.printf(Constants.STORE_CLOSED_MSG, store);
    }

    private void produceCustomers(List<CustomerWorker> customerWorkers) {
        for (int minute = 0; minute < Constants.MAX_STORE_OPENED_MINUTES; minute++) {
            for (int second = Constants.FIRST_SECOND; second <= Constants.LAST_SECOND; second++) {
                int maxQuantity;
                if (second <= Constants.MIDDLE_SECOND) {
                    maxQuantity = second + Constants.MIN_QUANTITY;
                } else {
                    maxQuantity = Constants.MAX_QUANTITY + (Constants.MIDDLE_SECOND - second);
                }
                int maxCustomerToEnter = maxQuantity - store.getCustomerQuantity();
                int numberCustomerPerSecond = RandomGenerator.getRandomInt(maxCustomerToEnter);
                for (int i = 0; i < numberCustomerPerSecond; i++) {
                    Customer customer = getRandomCustomer();
                    CustomerWorker customerWorker = new CustomerWorker(customer, store);
                    customerWorker.start();
                    customerWorkers.add(customerWorker);
                }
                Timer.sleep(Constants.TIMEOUT);
            }
        }
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

    private void closeStoreAfterLastCustomer(List<CustomerWorker> customerWorkers) {
        for (CustomerWorker customerWorker : customerWorkers) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
