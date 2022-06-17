package by.it.kadulin.jd02_02.entity;

import by.it.kadulin.jd02_02.util.RandomGenerator;

public class Pensioner extends Buyer {
    public Pensioner(long number, String name) {
        super(number, name);
        this.countWTB = RandomGenerator.get(2, 5);
        this.mltSpeedOperation = 1.5;
    }
}
