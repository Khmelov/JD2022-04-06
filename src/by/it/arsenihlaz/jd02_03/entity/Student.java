package by.it.arsenihlaz.jd02_03.entity;

import by.it.arsenihlaz.jd02_03.util.RandomGenerator;

public class Student extends Customer {
    public final String name;

    public Student(long number) {
        super(number);
        this.name = "Student №" + number;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int numberOfGoods() {
        return RandomGenerator.get(0, 2);
    }

}
