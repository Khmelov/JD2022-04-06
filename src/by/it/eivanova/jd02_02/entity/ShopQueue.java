package by.it.eivanova.jd02_02.entity;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShopQueue {
    private final Queue<Customer> queue;

    public ShopQueue() {
        this.queue = new ArrayDeque<>();
    }
    public synchronized void add(Customer customer){
        this.queue.add(customer);
    }
    public synchronized Customer extract(){
        return queue.poll();
    }
    public synchronized int getSize(){
       return queue.size();
    }
}
