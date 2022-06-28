package by.it.marchenko.jd02_03.models;

import by.it.marchenko.jd02_03.constants.CashierConstant;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Cashier {
    private static int startID = CashierConstant.DEFAULT_START_ID;

    private final String name;
    private final AtomicInteger servicedCustomerCount;
    private final AtomicReference<Double> atomicReceipts;

    private volatile boolean onWork;

    public Cashier() {
        //this.id = startID++;
        this.name = CashierConstant.CASHIER_DEFAULT_NAME + startID++;
        this.servicedCustomerCount = new AtomicInteger(0);
        this.onWork = true;
        this.atomicReceipts = new AtomicReference<>(0d);
    }

    public double getReceipts() {
        return atomicReceipts.get();
    }

    public void setReceipts(double receipts) {
        atomicReceipts.getAndSet(receipts);
    }

    public void increaseServicedCustomerCount() {
        servicedCustomerCount.getAndIncrement();
    }

    public int getServicedCustomerCount() {
        return servicedCustomerCount.intValue();
    }

    public boolean isOnWork() {
        return onWork;
    }

    public void setStatus(boolean status) {
        this.onWork = status;
    }

    @Override
    public String toString() {
        return "Cashier " + name;
    }
}
