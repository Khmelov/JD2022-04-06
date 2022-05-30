package by.it.machuga.jd02_01.service;

import by.it.machuga.jd02_01.entity.Customer;
import by.it.machuga.jd02_01.entity.Store;
import by.it.machuga.jd02_01.util.RandomGenerator;
import by.it.machuga.jd02_01.util.Timer;

import java.util.ArrayList;
import java.util.List;

public class StoreWorker extends Thread{

    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(store+" opened");
        List<CustomerWorker>customerWorkers=new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int numberCustomerParSecond = RandomGenerator.getRandomInt(2);
            for (int i = 0; i < numberCustomerParSecond; i++) {
                Customer customer = new Customer(RandomGenerator.getRandomText(4));
                CustomerWorker customerWorker=new CustomerWorker(customer, store);
                customerWorker.start();
                customerWorkers.add(customerWorker);
            }
            Timer.sleep(1000);
        }
        for (CustomerWorker customerWorker : customerWorkers) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(store+" closed");
    }

    @Override
    public String toString() {
       return  store.toString();
    }
}
