package by.it.ragach.jd02_01.entity;

public class Shop {

    private final String name;

    public Shop (String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shop "+name;
    }
}
