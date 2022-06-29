package by.it.eivanova.jd02_02.entity;

import by.it.eivanova.jd02_02.util.RandomGenerator;

public class Pensioner extends Customer {


    public Pensioner(long number) {
        super(number);
    }

    @Override
    public int getSpeedFactor() {
        int factor = RandomGenerator.get(1,2);
        return super.getSpeedFactor()*factor;
    }

    @Override
    public String toString() {
        return super.name+" pensioner";
    }
}
