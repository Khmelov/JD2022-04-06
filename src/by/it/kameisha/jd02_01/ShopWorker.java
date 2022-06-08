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
        for (int timeMinute = 0; timeMinute < 2; timeMinute++) {
            for (int timeSecond = 0; timeSecond < 60; timeSecond++) {
                int countCustomersPerSecond = 0;
                if (timeSecond < 30 && ShopWorker.activeCount() < timeSecond + 10) {
                    countCustomersPerSecond = timeSecond + 10 - ShopWorker.activeCount();
                } else if (timeSecond >= 30 && ShopWorker.activeCount() < 40 + (30 - timeSecond)) {
                    countCustomersPerSecond = 40 + (30 - timeSecond) - ShopWorker.activeCount();
                }
                for (int i = 0; i < countCustomersPerSecond; i++) {
                    Customer customer = createRandomCustomer(++number);
                    CustomerWorker customerWorker = new CustomerWorker(customer, shop, repository);
                    customerWorker.start();
                    customerWorkerList.add(customerWorker);
                }
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

    private Customer createRandomCustomer(int number) {
        Customer customer;
        int random = RandomGenerator.get(1, 12);
        if (random < 4) {
            customer = new Customer(number);
        } else if (random < 7) {
            customer = new Pensioner(number);
        } else {
            customer = new Student(number);
        }
        return customer;
    }
}
