package by.it.arsenihlaz.jd02_02.entity;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
    private final Deque<Customer> deque;

    public Queue() {
        deque = new ArrayDeque<>();
    }

    public void add(Customer customer) {
        synchronized (deque){
            deque.add(customer);
        }
    }

    public synchronized Customer extract() {
        return deque.poll();
    }

    public int getSize(){
        return deque.size();
    }
}

