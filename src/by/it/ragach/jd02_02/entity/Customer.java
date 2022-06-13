package by.it.ragach.jd02_02.entity;

public class Customer {
    public final String name;

    public Customer(long number){ this.name = "Customer №"+number;
    }
    @Override
    public String toString() { return name;
    }
}
