package by.it.marchenko.jd02_01.models;

public class Cashier {
    public static final String CASHIER_DEFAULT_NAME = "Cashier#";

    public final int id;
    public final String name;

    public Cashier(int id) {
        this.id = id;
        this.name = CASHIER_DEFAULT_NAME + id;
    }

    @Override
    public String toString() {
        return "cashier " + name;
    }
}
