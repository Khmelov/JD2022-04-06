package by.it.annazhegulovich.jd02_01;

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
