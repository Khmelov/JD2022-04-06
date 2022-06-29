package by.it.eivanova.jd02_01;

public class Customer {

    private final String name;
    public Customer(String type, long number) {
        this.name = "Customer " + type + " №" + number;
    }

    @Override
    public String toString() {
        return name;
    }
}
