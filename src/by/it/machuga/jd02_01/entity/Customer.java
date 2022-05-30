package by.it.machuga.jd02_01.entity;

public class Customer {

    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer "+ name;
    }
}
