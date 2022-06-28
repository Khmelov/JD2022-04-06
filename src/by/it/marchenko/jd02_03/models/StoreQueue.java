package by.it.marchenko.jd02_03.models;

import by.it.marchenko.jd02_03.exception.StoreException;
import by.it.marchenko.jd02_03.interfaces.StoreQueueAction;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static by.it.marchenko.jd02_03.constants.StoreConstant.*;
import static by.it.marchenko.jd02_03.constants.StoreExceptionConstant.*;

public class StoreQueue implements StoreQueueAction {
    private final BlockingQueue<Customer> storeQueue;

    public StoreQueue() {
        this.storeQueue = new LinkedBlockingQueue<>(QUEUE_LIMIT);
    }

    @Override
    public int getSize() {
        synchronized (storeQueue) {
            return QUEUE_LIMIT - storeQueue.remainingCapacity();
        }
    }

    @Override
    public void add(Customer customer) {
        try {
            storeQueue.put(customer);
        } catch (InterruptedException e) {
            throw new StoreException(INTERRUPTED_PUTTING_CUSTOMER_INTO_THE_QUEUE, e);
        }
    }

    @Override
    public Customer remove() {
        Customer customer;
        try {
            customer = storeQueue.take();
        } catch (InterruptedException e) {
            throw new StoreException(INTERRUPTED_EXTRACTING_CUSTOMER_FROM_THE_QUEUE, e);
        }
        return customer;
    }

    @Override
    public int calcExpectedCashierCount(boolean mode) {
        int expectedCashierCount = (int) Math.ceil(storeQueue.size() / (double) CUSTOMERS_PER_CASHIER);
        return mode ?
                DEFAULT_CASHIER_COUNT :
                Math.min(expectedCashierCount, MAX_CASHIER_COUNT);
    }
}
