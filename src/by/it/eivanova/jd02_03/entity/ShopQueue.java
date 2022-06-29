package by.it.eivanova.jd02_03.entity;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ShopQueue {

    public static final int MAX_LENGTH = 30;
    private final BlockingQueue<Customer> queue;

    public ShopQueue(){
        this.queue = new ArrayBlockingQueue<>(MAX_LENGTH);
    }

    public void add(Customer customer){
        try {
            this.queue.put(customer);
            } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Customer extract(){
        return queue.poll();
    }

    public  int getSize(){
        return queue.size();
    }
}