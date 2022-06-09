package by.it.avramchuk.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread{
    private final Shop shop;
    private int number=0;
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
        List<CustomerWorker> customerWorkerList = new ArrayList<>();
        for (int min = 0; min < 2; min++) {
            for (int sec = 0; sec < 60; sec++) {
                int currentCount = 0;
                for (CustomerWorker c : customerWorkerList) {
                    if (c.isAlive()) {
                        currentCount++;
                    }
                }
                int countCustomerPerSecond = needToAdd(currentCount, sec);
                for (int i = 0; i < countCustomerPerSecond; i++) {
                    Customer customer = defineCustomer();
                    CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                    customerWorker.start();
                    customerWorkerList.add(customerWorker);
                }
                System.out.println("\n at " + sec + " second " + currentCount + " customers in the store\n" );
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
        System.out.println("\n total visitors: "+ number);
    }

    public Customer defineCustomer(){
        Customer customer;
        int whoIsCustomer = RandomGenerator.get(100);
        if (whoIsCustomer <= 25) {
            customer = new Pensioner(++number);
        } else if (whoIsCustomer >= 50) {
            customer = new Student(++number);
        } else {
            customer = new Customer(++number);
        }
        return customer;
    }

    public int needToAdd (int currentCount, int sec){
        int countCustomerPerSecond=0;
        if(sec<30) {
            countCustomerPerSecond = (sec+15)-currentCount;
        }else if(currentCount<=(40+(30-sec))){
            countCustomerPerSecond = (40+(30-sec))-currentCount;
        }
        return countCustomerPerSecond;
    }
}
