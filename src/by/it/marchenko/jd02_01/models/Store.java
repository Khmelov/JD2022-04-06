package by.it.marchenko.jd02_01.models;

import static by.it.marchenko.jd02_01.constants.StoreConstant.*;

public class Store {

    public final int id;
    public final String name;

    public Store(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s %s #%d", STORE, name, id);
    }
}
