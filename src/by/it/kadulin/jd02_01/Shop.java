package by.it.kadulin.jd02_01;

public class Shop {

    public final String name;

    public Shop(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shop " + name ;
    }
}
