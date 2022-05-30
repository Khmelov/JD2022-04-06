package by.it._classwork_.jd02_01;

public class Customer {

    private static long currentId = System.currentTimeMillis();

    private final String name;
    private final long id;

    public Customer(long number) {
        id = currentId++;
        this.name = "Customer №" + number;
    }

    @Override
    public String toString() {
        return name;
    }
}
