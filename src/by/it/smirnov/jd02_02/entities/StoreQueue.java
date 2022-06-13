package by.it.smirnov.jd02_02.entities;

import by.it.smirnov.jd02_02.entities.customer_types.Customer;

import java.util.LinkedList;
import java.util.Queue;

public class StoreQueue {

    public Queue<Customer> queue;

    public StoreQueue() {
        queue = new LinkedList<>();
    }

    public void add(Customer customer) {
        synchronized (this) {
            queue.add(customer);
        }
    }

    public synchronized Customer extract() {
        return queue.poll();
    }
}
