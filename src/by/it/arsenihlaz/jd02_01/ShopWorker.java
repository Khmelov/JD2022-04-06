package by.it.arsenihlaz.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread {
    private final Shop shop;
    int number = 0;

    public ShopWorker(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(shop + " opened");

        List<CustomerWorker> customerWorkerList = new ArrayList<>();
        int customerPerSecond;
        for (int time = 0; time < 120; time++) {
            int numberOfBuyers = CustomerWorker.countBuyers();
            int second = time % 60;

            if (second < 30) {
                customerPerSecond = RandomGenerator.get(10+second/2);
            } else if (second >= 30 && numberOfBuyers <= (40 + (30 - second))) {
                customerPerSecond = (40 + (30 - second)-numberOfBuyers);
            } else customerPerSecond = 0;

            for (int i = 0; i < customerPerSecond; i++) {
                Customer customer = customerGenerator();
                CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                customerWorker.start();
                customerWorkerList.add(customerWorker);
            }
            Timer.sleep(1000);
            System.out.println("количество покупателей " + numberOfBuyers);
            System.out.println(second);
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

    private Customer customerGenerator() {
        int customerType = RandomGenerator.get(0, 99);
        Customer customer;
        if (customerType < 25) {
            customer = new Pensioner(++number);
        } else if (customerType >= 75) {
            customer = new Customer(++number);
        } else {
            customer = new Student(++number);
        }
        return customer;
    }

}
