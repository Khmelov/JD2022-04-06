package by.it.arsenihlaz.jd02_03.entity;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {
    private final BlockingDeque<Customer> deque;

    public Queue() {
        deque = new LinkedBlockingDeque<>(30);
    }

    public void add(Customer customer) {
        try {
            deque.put(customer);
            synchronized (this) {
                this.notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer extract() {
        return deque.poll();
    }

    public int getSize() {
        return deque.size();
    }
}

