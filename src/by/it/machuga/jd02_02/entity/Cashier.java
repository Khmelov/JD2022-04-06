package by.it.machuga.jd02_02.entity;

public class Cashier {
    private final String name;

    public Cashier(int number) {
        this.name = "Cashier №" + number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
