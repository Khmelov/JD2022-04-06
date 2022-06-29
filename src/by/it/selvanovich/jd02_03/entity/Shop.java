package by.it.selvanovich.jd02_03.entity;

public class Shop {

    private final String name;
    private final Queue queue;
    private final Manager manager;

    public Shop(String name, Queue queue, Manager manager) {
        this.name = name;
        this.queue = queue;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public Queue getQueue() {
        return queue;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public String toString() {
        return "Shop " + name;
    }
}
