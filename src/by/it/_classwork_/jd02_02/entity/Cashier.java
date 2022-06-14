package by.it._classwork_.jd02_02.entity;

public class Cashier {

    public final String name;

    public Cashier(int number) {
        this.name = "Casier №" + number;
    }

    @Override
    public String toString() {
        return "\t" + name;
    }
}
