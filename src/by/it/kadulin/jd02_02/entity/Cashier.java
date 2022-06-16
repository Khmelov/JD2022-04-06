package by.it.kadulin.jd02_02.entity;

public class Cashier {
    public static int cashierMaxLimit = 5;
    public static final int buyersPerCashier = 5;
    private final int cashierNumber;
    private final String name;

    public Cashier(int number) {
        this.name = "Cashier #" + number;
        this.cashierNumber = number;
    }

    public int getCashierNumber() {
        return cashierNumber;
    }



    @Override
    public String toString() {
        return "\t" + name;
    }
}
