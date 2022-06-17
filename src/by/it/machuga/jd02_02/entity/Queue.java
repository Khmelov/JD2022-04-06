package by.it.machuga.jd02_02.entity;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {

    private final Deque<Customer> deque;

    public Queue() {
        deque = new ArrayDeque<>();
    }

    public synchronized void add(Customer customer) {
        deque.add(customer);
    }

    public synchronized Customer extract() {
        return deque.poll();
    }

    @Override
    public String toString() {
        return "Queue{" +
                "deque=" + deque +
                '}';
    }

    public int getSize() {
        return deque.size();
    }
}
