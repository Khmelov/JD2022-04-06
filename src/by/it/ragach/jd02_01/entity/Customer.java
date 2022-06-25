package by.it.ragach.jd02_01.entity;

import by.it.ragach.jd02_01.util.RandomGenerator;

public class Customer {
    public final String name;

    public Customer(long number){ this.name = "Customer №"+number;
    }
    @Override
    public String toString() { return name;
    }

    public int numberOfGoods(){
        return RandomGenerator.get(2,5);
    }

    public double speedOfOperation(){
        return 1.0;

    }




}
