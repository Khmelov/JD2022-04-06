package by.it.marchenko.jd02_01;

import by.it.marchenko.jd02_01.utility.RandomGenerator;

import static by.it.marchenko.jd02_01.CustomerConstant.*;

public class Customer {


    private static int startId = 1;
    private final String name;
    private final int id;
    private final long cash;

    public Customer(String name, long cash) {
        this.name = name;
        this.id = startId++;
        this.cash = cash;
    }

    public Customer() {
        id = startId++;
        this.name = DEFAULT_CUSTOMER_NAME_PREFIX + id;
        this.cash = RandomGenerator.getRandom(MIN_RANDOM_CASH, MAX_RANDOM_CASH);
    }

    @Override
    public String toString() {
        return String.format("%s #%-3d %s ", CUSTOMER, id, name);
    }
}
