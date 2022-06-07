package by.it.smirnov.jd02_02;

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
