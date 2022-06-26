package by.it.eivanova.jd02_03.entity;

public class Cashier {

    private final String name;

    public Cashier(int number) {
        this.name = "Cashier №"+number;
    }

    @Override
    public String toString() {
        return name;
    }
}
