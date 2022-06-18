package by.it.arsenihlaz.jd02_03.entity;

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

    public Manager getManager() {
        return manager;
    }

    public Queue getQueue() {
        return queue;
    }

    @Override
    public String toString() {
        return "Shop " + name;
    }
}
