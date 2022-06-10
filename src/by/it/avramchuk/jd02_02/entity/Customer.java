package by.it.avramchuk.jd02_02.entity;

import by.it.avramchuk.jd02_02.util.RandomGenerator;

public class Customer {

    public final String name;
    private final int speedFactor;
    public boolean isWaiting;
    public Customer(long number) {
        this.name = "Customer №"+number;
        this.speedFactor = 1;
    }

    public int getSpeedFactor(){
        return speedFactor;
    }

    public int mayToBuy(){
        return RandomGenerator.get(2,5);
    }

    @Override
    public String toString() {
        return name;
    }
}
