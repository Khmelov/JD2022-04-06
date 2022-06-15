package by.it.marchenko.jd02_03.models;

import by.it.marchenko.jd02_03.constants.CashierConstant;

public class Cashier {
    private static int startID = CashierConstant.DEFAULT_START_ID;

    private final String name;

    private double receipts;
    private boolean waitEnabled;
    private int servicedCustomerCount;

    private volatile boolean onWork;
    //int id;

    public Cashier() {
        //this.id = startID++;
        this.name = CashierConstant.CASHIER_DEFAULT_NAME + startID++;
        this.receipts = 0;
        this.servicedCustomerCount = 0;
        this.onWork = true;

        this.waitEnabled = false;
    }

    public double getReceipts() {
        return receipts;
    }

    public void setReceipts(double receipts) {
        this.receipts = receipts;
    }

    public boolean isWaitEnabled() {
        return waitEnabled;
    }

    public void setWaitEnabled(boolean waitEnabled) {
        this.waitEnabled = waitEnabled;
    }

    public void increaseServicedCustomerCount() {
        this.servicedCustomerCount++;
    }

    public int getServicedCustomerCount() {
        return servicedCustomerCount;
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
