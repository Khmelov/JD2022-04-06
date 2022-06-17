package by.it.avramchuk.jd02_03.services;

import by.it.avramchuk.jd02_03.entity.*;
import by.it.avramchuk.jd02_03.util.RandomGenerator;
import by.it.avramchuk.jd02_03.util.Timer;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread{
    private final Shop shop;
    private int visitors =0;
    List<CustomerWorker> customerWorkerList = new ArrayList<>();
    public ShopWorker(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return shop.toString();
    }

    @Override
    public void run() {
        Manager manager = shop.getManager();
        int sec=0;
        System.out.println(shop+" opened");

        while (manager.shopOpened()) {
            int currentCount = getCurrentCount();
            System.out.println("\n at " + sec%60 + " second " + currentCount + " customers in the store\n");

            int countCustomerPerSecond = needToAdd(currentCount, sec);
            for (int i = 0;manager.shopOpened()&& i < countCustomerPerSecond; i++) {
                Customer customer = defineCustomer();
                CustomerWorker customerWorker = new CustomerWorker(customer, shop);
                customerWorker.start();
                customerWorkerList.add(customerWorker);
            }
            Timer.sleep(1000);
            sec++;
        }
        for (CustomerWorker customerWorker : customerWorkerList) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(shop+" closed");
        System.out.println("\n total visitors: "+ visitors);
    }

    private int getCurrentCount() {
        int currentCount = 0;
        for (CustomerWorker c : customerWorkerList) {
            if (c.getState()!= State.TERMINATED) {
                currentCount++;
            }
        }
        return currentCount;
    }

    public Customer defineCustomer(){
        Customer customer;
        int whoIsCustomer = RandomGenerator.get(100);
        if (whoIsCustomer <= 25) {
            customer = new Pensioner(++visitors);
        } else if (whoIsCustomer >= 50) {
            customer = new Student(++visitors);
        } else {
            customer = new Customer(++visitors);
        }
        return customer;
    }

    public int needToAdd (int currentCount, int sec){
        int countCustomerPerSecond=0;
        if(sec%60<30) {
            countCustomerPerSecond = (sec+10)-currentCount;
        }else if(currentCount<=(40+(30-sec))){
            countCustomerPerSecond = (40+(30-sec))-currentCount;
        }
        return countCustomerPerSecond;
    }
    public int cashierNeeded (){
        ShopQueue queue = shop.getQueue();
        int neededCount = queue.getSize()/5;
        if (neededCount%5!=0){neededCount++;}
        return Math.min(neededCount, 5);
    }
}
