package by.it.avramchuk.jd02_02.entity;

import by.it.avramchuk.jd02_02.util.RandomGenerator;

public class Student extends Customer {
    public Student(long number) {
        super(number);
    }

    @Override
    public String toString() {
        return super.name+" student";
    }

    @Override
    public int mayToBuy() {
        return RandomGenerator.get(2);
    }
}
