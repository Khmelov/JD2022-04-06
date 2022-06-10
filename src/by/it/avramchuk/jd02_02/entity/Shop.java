package by.it.avramchuk.jd02_02.entity;

public class Shop {

    private final String name;
    private final ShopQueue queue;

    public Shop(String name, ShopQueue queue) {
        this.name = name;
        this.queue=queue;
    }

    public ShopQueue getQueue(){
        return this.queue;
    }

    @Override
    public String toString() {
        return "Shop: "+name;
    }
}
