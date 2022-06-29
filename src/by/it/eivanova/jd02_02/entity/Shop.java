package by.it.eivanova.jd02_02.entity;

public class Shop {

    private final String name;
    private final ShopQueue queue;
    private final Manager manager;

    public Shop(String name, ShopQueue queue, Manager manager) {
        this.manager= manager;
        this.name = name;
        this.queue=queue;
    }

    public ShopQueue getQueue(){
        return this.queue;
    }

    public Manager getManager(){
        return this.manager;
    }

    @Override
    public String toString() {
        return "Shop: "+name;
    }
}
