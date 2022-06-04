package by.it.marchenko.jd02_02.models;

import static by.it.marchenko.jd02_02.constants.StoreConstant.STORE;

public class Store {

    private static int startID = 1;

    private final int id;
    private final String name;
    private final Manager manager;

    public Store(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
        this.id = startID++;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public String toString() {
        return String.format("%s %s #%d", STORE, name, id);
    }
}
