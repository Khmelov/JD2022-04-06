package by.it.machuga.jd02_03.entity;

import by.it.machuga.jd02_03.util.Constants;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {

    private final BlockingDeque<Customer> deque;

    public Queue() {
        deque = new LinkedBlockingDeque<>(Constants.MAX_LENGTH_QUEUE);
    }

    public void add(Customer customer) {
        try {
            deque.put(customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Customer extract() {
        return deque.poll();
    }

    public int getSize() {
        return deque.size();
    }

    @Override
    public String toString() {
        return "Queue{" +
                "deque=" + deque +
                '}';
    }
}
