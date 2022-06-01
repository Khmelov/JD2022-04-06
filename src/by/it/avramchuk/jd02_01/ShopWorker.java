package by.it.avramchuk.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread{
    private final Shop shop;

    public ShopWorker(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return shop.toString();
    }

    @Override
    public void run() {
        System.out.println(shop+" opened");
        int number=0;
        List<CustomerWorker> customerWorkerList = new ArrayList<>();
        for (int min = 0; min < 2; min++) {
            for (int sec = 0; sec < 60; sec++) {
                int currentCount = 0;
                for (CustomerWorker c : customerWorkerList) {
                    if (c.isAlive()) {
                        currentCount++;
                    }
                }
                int countCustomerPerSecond=0;
                if(sec<30) {
                    countCustomerPerSecond = (sec+15)-currentCount;
                }else if(currentCount<=(40+(30-sec))){
                    countCustomerPerSecond = (40+(30-sec))-currentCount;
                }
                for (int i = 0; i < countCustomerPerSecond; i++) {

                    int whoIsCustomer = RandomGenerator.get(100);
                    Customer customer;
                    if (whoIsCustomer <= 25) {
                        customer = new Pensioner(++number);
                    } else if (whoIsCustomer >= 50) {
                        customer = new Student(++number);
                    } else {
                        customer = new Customer(++number);
                    }

                    CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                    customerWorker.start();
                    customerWorkerList.add(customerWorker);
                }
                System.out.println("\n at " + sec + " second " + currentCount + "\n");
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
        System.out.println(shop+" closed");
    }
}
