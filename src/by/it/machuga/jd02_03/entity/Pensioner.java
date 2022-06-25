package by.it.machuga.jd02_03.entity;

import by.it.machuga.jd02_03.util.Constants;

public class Pensioner extends Customer {
    private final double selectionSpeed = 1.5;

    public Pensioner(String name) {
        super(name);
    }

    @Override
    public double getSelectionSpeed() {
        return selectionSpeed;
    }

    @Override
    public String toString() {
        return Constants.PENSIONER + getName();
    }
}
