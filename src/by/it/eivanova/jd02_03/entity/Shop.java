package by.it.eivanova.jd02_03.entity;

public class Shop {

    private final String name;
    private final ShopQueue queue;
    private final Manager manager;

    public Shop(String name, ShopQueue queue, Manager manager){
        this.name = name;
        this.queue = queue;
        this.manager = manager;
    }

    public Manager getManager(){
        return manager;
    }

    public ShopQueue getQueue(){
        return this.queue;
    }

    @Override
    public String toString() {
        return "Shop: "+name;
    }
}
