package by.it.marchenko.jd02_02.models;

import by.it.marchenko.jd02_02.constants.CashierConstant;

public class Cashier {
    private static int startID = CashierConstant.DEFAULT_START_ID;

    private final int id;
    private final String name;

    private double receipts;

    public Cashier() {
        this.id = startID++;
        this.name = CashierConstant.CASHIER_DEFAULT_NAME + id;
        this.receipts = 0;
    }

    public double getReceipts() {
        return receipts;
    }

    public void setReceipts(double receipts) {
        this.receipts = receipts;
    }

    @Override
    public String toString() {
        return "Cashier " + name;
    }
}
