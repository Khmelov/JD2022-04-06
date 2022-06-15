package by.it.kadulin.jd02_02.entity;

import by.it.kadulin.jd02_02.interfaces.BuyerAction;
import by.it.kadulin.jd02_02.util.RandomGenerator;

public class Student extends Buyer {

    public Student(long number, String name) {
        super(number, name);
        this.countWTB = RandomGenerator.get(2);
        this.mltSpeedOperation = 1;
    }
}
