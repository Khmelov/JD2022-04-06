package by.it.edeborg.jd02_01;

public class Customer {

    public final String name;

    public Customer(long number) {
        this.name = "Customer №"+number;
    }

    @Override
    public String toString() {
        return name;
    }
}
