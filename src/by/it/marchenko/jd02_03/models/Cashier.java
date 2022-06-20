package by.it.marchenko.jd02_03.models;

import by.it.marchenko.jd02_03.constants.CashierConstant;

import java.util.concurrent.atomic.AtomicInteger;

public class Cashier {
    private static int startID = CashierConstant.DEFAULT_START_ID;

    private final String name;
    private final AtomicInteger servicedCustomerCount;

    private double receipts;
    //private boolean waitEnabled;

    private volatile boolean onWork;
    //int id;

    public Cashier() {
        //this.id = startID++;
        this.name = CashierConstant.CASHIER_DEFAULT_NAME + startID++;
        this.receipts = 0;
        this.servicedCustomerCount = new AtomicInteger(0);
        this.onWork = true;

        //  this.waitEnabled = false;
    }

    public double getReceipts() {
        return receipts;
    }

    public void setReceipts(double receipts) {
        this.receipts = receipts;
    }

    /*
    public boolean isWaitEnabled() {
        return waitEnabled;
    }

    public void setWaitEnabled(boolean waitEnabled) {
        this.waitEnabled = waitEnabled;
    }
 */

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
