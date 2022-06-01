package by.it.kameisha.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread {
    private final Shop shop;
    private final PriceListRepository repository;

    public ShopWorker(Shop shop, PriceListRepository repository) {
        this.shop = shop;
        this.repository = repository;
    }

    @Override
    public void run() {
        System.out.println(shop + " opened");
        int number = 0;

        List<CustomerWorker> customerWorkerList = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int countCustomersPerSecond = RandomGenerator.get(2);
            for (int i = 0; i < countCustomersPerSecond; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(customer, shop, repository);
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
        System.out.println(shop + " closed");
    }
}
