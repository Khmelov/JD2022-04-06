package by.it.edeborg.jd02_03.organization;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {

    public static final int MAX_LENGTH_QUEUE = 30;
    private final BlockingDeque<Customer> deque;

    public Queue() {
        deque = new LinkedBlockingDeque<>(MAX_LENGTH_QUEUE);
    }

    public void add(Customer customer) {
        try {
            deque.put(customer);
            synchronized (this){
                this.notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer extract() {
        return deque.poll();
    }
}
