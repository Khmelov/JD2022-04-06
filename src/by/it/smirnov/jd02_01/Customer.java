package by.it.smirnov.jd02_01;

public class Customer {

    public final String name;

    public Customer(int number) {
        this.name = "Customer №" + number;
    }

    @Override
    public String toString() {
        return name;
    }
}
