package by.it.kadulin.jd02_03.entity;

import by.it.kadulin.jd02_03.util.RandomGenerator;

public class Customer extends Buyer {

    public Customer(long number, String name) {
        super(number, name);
        this.mltSpeedOperation = 1;
        this.countWTB = RandomGenerator.get(2, 5);
    }

    @Override
    public String toString() {
        return name + "# " + number;
    }
}
