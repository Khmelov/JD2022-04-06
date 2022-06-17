package by.it.ragach.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread{
    private final Shop shop;
    int number=0;


    public ShopWorker (Shop shop){
        this.shop = shop;
    }
    
    @Override
    public void run() {
        System.out.println(shop+" opened");
        List<CustomerWorker>customerWorkerList = new ArrayList<>();



        for (int time = 0; time < 120; time++) {
            int countCustomerPerSecond = RandomGenerator.get(2);
            for (int i = 0; i < countCustomerPerSecond; i++) {
                Customer customer = customerCreator();
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
                throw new RuntimeException(e);
            }

        }
        System.out.println(shop+" closed");
    }

    private Customer customerCreator() {

        int customerType = RandomGenerator.get(0,99);
        Customer customer;
        if (customerType<25){
            customer = new Pensioner(++number);
        }else if (customerType>=75){
            customer = new Customer(++number);
        }else {
            customer = new Student(++number);
        }
        return customer;
    }

}
