package by.it.kadulin.jd02_01;

public class Customer {
    private final String name;

    public Customer(long number) {
        this.name = "Customer #" + number;
    }

    @Override
    public String toString() {
        return name;
    }
}
