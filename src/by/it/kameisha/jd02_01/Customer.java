package by.it.kameisha.jd02_01;

public class Customer {
    private static long currentId = System.currentTimeMillis();
    public final String name;
    public final long id;
    public Customer(long number) {
        id = ++currentId;
        name = "Customer №"+number;
    }

    @Override
    public String toString() {
        return name;
    }
}
