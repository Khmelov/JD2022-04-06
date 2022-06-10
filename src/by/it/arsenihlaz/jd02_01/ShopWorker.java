package by.it.arsenihlaz.jd02_01;

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
        List<CustomerWorker> customerWorkerList = new ArrayList<>();
        int customerPerSecond;
        for (int time = 0; time < 120; time++) {
            int numberOfBuyers = customerWorkerList.size();
            System.out.println("количество покупателей " + customerWorkerList.size());
            int second = time % 60;
            if (second < 30 && numberOfBuyers < (second + 10)) {
                customerPerSecond = RandomGenerator.get((40-numberOfBuyers)*2);
            } else if (second >= 30 && numberOfBuyers <= (40 + (30 - second))) {
                customerPerSecond = RandomGenerator.get(40-numberOfBuyers);
            } else customerPerSecond = RandomGenerator.get(1);

            for (int i = 0; i < customerPerSecond; i++) {
                int customerType = RandomGenerator.get(0, 99);
                if (customerType < 25) {
                    Customer pensioner = new Pensioner(++number);
                    CustomerWorker pensionerWorker = new CustomerWorker(pensioner, shop);
                    pensionerWorker.start();
                    customerWorkerList.add(pensionerWorker);
                } else if (customerType >= 25 && customerType < 50) {
                    Customer customer = new Customer(++number);
                    CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                    customerWorker.start();
                    customerWorkerList.add(customerWorker);
                } else {
                    Customer student = new Student(++number);
                    CustomerWorker studentWorker = new CustomerWorker(student, shop);
                    studentWorker.start();
                    customerWorkerList.add(studentWorker);
                }
            }
            Timer.sleep(1000);
            customerWorkerList.removeIf(customerWorker -> customerWorker.getState() == State.TERMINATED);
            System.out.println("количество покупателей " + customerWorkerList.size());
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

}
