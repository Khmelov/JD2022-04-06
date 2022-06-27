package by.it.kadulin.jd02_03.entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Queue {

    private int cashierClosed = 0;

    private final BlockingDeque<Buyer> deque;

    public Queue() {
        deque = new LinkedBlockingDeque<>(30);
    }

    public void add(Buyer buyer) {

        try {
            deque.put(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public synchronized int getQueueSize() {
        return deque.size();
    }

    public Buyer extract() {
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
