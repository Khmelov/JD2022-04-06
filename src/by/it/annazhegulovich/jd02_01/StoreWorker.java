package by.it.annazhegulovich.jd02_01;

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
        List<CustomerWorker> customerWorkerList=new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int i = 0; i < countCustomerPerSecond; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(customer, store);
                customerWorker.start();
                customerWorkerList.add(customerWorker);
                Timer.sleep(1000);
            }
        }
        for (CustomerWorker customerWorker : customerWorkerList) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(store + " closed");

    }
}
