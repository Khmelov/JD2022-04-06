package by.it.marchenko.jd02_02.models;

import by.it.marchenko.jd02_02.utility.RandomGenerator;

import static by.it.marchenko.jd02_02.constants.CustomerConstant.*;

public class Customer {

    private final String name;
    private final int id;
    //private final String type = CUSTOMER;

    private static int startId = 1;

    @SuppressWarnings("unused")
    private final long cash;

    @SuppressWarnings("unused")
    public Customer(String name, long cash) {
        this.id = startId++;
        this.name = name;
        this.cash = cash;

    }

    public Customer() {
        this.id = startId++;
        this.name = DEFAULT_CUSTOMER_NAME_PREFIX + id;
        this.cash = RandomGenerator.getRandom(MIN_RANDOM_CASH, MAX_RANDOM_CASH);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSpeedDownCoefficient() {
        return CUSTOMER_SPEED_DOWN_COEFFICIENT;
    }

    //   public int getSpeedDownCoefficient() {
    //       return CUSTOMER_SPEED_DOWN_COEFFICIENT;
    //   }

    @SuppressWarnings("unused")
    public long getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return String.format("%-10s #%-3d %7s ", CUSTOMER, id, name);
    }

    public int getMinCartCapacity() {
        return CUSTOMER_MIN_CART_CAPACITY;
    }

    public int getMaxCartCapacity() {
        return CUSTOMER_MAX_CART_CAPACITY;
    }
}
