package by.it.ragach.jd02_01.service;

import by.it.ragach.jd02_01.util.RandomGenerator;
import by.it.ragach.jd02_01.util.Timer;
import by.it.ragach.jd02_01.entity.Customer;
import by.it.ragach.jd02_01.entity.Pensioner;
import by.it.ragach.jd02_01.entity.Shop;
import by.it.ragach.jd02_01.entity.Student;

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
            int numberCustomerPerSecond = CustomerWorker.countBuyers();
            int second = time % 60;
            customerPerSecond = getCustomerPerSecond(numberCustomerPerSecond, second);
            for (int i = 0; i < customerPerSecond; i++) {
                Customer customer = customerCreator();
                CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                customerWorker.start();
                customerWorkerList.add(customerWorker);
            }
                Timer.sleep(1000);
                System.out.println("\tQuantity of buyers " + numberCustomerPerSecond);
                System.out.println(second);

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

    private int getCustomerPerSecond(int countCustomerPerSecond, int second) {
        int customerPerSecond;
        if (second<30){
            customerPerSecond = RandomGenerator.get(10+second/3);
        }else if (second>=30&&countCustomerPerSecond<=(40+(30-second))){
            customerPerSecond = RandomGenerator.get(40+(30-second)-countCustomerPerSecond);
        }else {
            customerPerSecond = 0;
        }
        return customerPerSecond;
    }

    private Customer customerCreator() {

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
