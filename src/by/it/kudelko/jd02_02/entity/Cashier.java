package by.it.kudelko.jd02_02.entity;

public class Cashier {

    public final String name;

    public Cashier(int number) {
        this.name = "Cashier N" + number;
    }

    @Override
    public String toString() {
        return "\t" + name;
    }
}
