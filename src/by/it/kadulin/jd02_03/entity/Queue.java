package by.it.kadulin.jd02_03.entity;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {

    private int cashierClosed = 0;

    private final Deque<Buyer> deque;

    public Queue() {
        deque = new ArrayDeque<>();
    }

    public void add(Buyer buyer) {
        synchronized (deque) {
            deque.add(buyer);
        }

    }

    public synchronized int getQueueSize() {
        return deque.size();
    }

    public synchronized Buyer extract() {
        return deque.poll();
    }

    public synchronized void cashierOpens() {
        cashierClosed--;
    }

    public synchronized void cashierCloses() {
        cashierClosed++;
    }

    public synchronized int cashierInWork() {
        return Cashier.cashierMaxLimit - cashierClosed;
    }
}
