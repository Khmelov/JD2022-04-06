package by.it.smirnov.jd02_01.entities;

import by.it.smirnov.jd02_02.entities.Manager;
import by.it.smirnov.jd02_02.entities.StoreQueue;

public class Store {

    private final String name;

    public Store(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Store " + name;
    }


}
