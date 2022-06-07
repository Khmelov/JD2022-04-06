package by.it.marchenko.jd02_02.models;

import by.it.marchenko.jd02_02.constants.CashierConstant;

public class Cashier {
    private static int startID = CashierConstant.DEFAULT_START_ID;

    public final int id;
    public final String name;

    public Cashier() {
        this.id = startID++;
        this.name = CashierConstant.CASHIER_DEFAULT_NAME + id;
    }

    @Override
    public String toString() {
        return "Cashier " + name;
    }
}
