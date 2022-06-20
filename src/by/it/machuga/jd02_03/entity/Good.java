package by.it.machuga.jd02_03.entity;

import by.it.machuga.jd02_03.util.Constants;

public class Good {

    private final String name;

    public Good(String name) {
        this.name = Constants.GOOD + name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
