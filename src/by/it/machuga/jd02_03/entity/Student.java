package by.it.machuga.jd02_03.entity;

import by.it.machuga.jd02_03.util.Constants;

public class Student extends Customer {
    private final int maxGood = 2;
    private final int minGood = 0;

    public Student(String name) {
        super(name);
    }

    @Override
    public int getMaxGood() {
        return maxGood;
    }

    @Override
    public int getMinGood() {
        return minGood;
    }

    @Override
    public String toString() {
        return Constants.STUDENT + getName();
    }
}
