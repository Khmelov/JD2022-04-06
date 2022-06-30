package by.it.edeborg.jd02_01;

public class Shop {

    private final String name;

    public Shop(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shop: " + name;
    }
}
