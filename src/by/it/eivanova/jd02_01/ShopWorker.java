package by.it.eivanova.jd02_01;

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
        int number = 0;
        List<CustomerWorker> customerWorkerList=new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int i = 0; i < countCustomerPerSecond; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                customerWorker.start();
                customerWorkerList.add(customerWorker);
                Timer.sleep(1000);
            }
        }

        for (CustomerWorker customerWorker : customerWorkerList) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(shop + " closed");
    }


}