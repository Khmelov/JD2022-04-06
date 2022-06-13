package by.it.ragach.jd02_02.entity;

public class Shop {

    private final String name;
    private final Queue queue;

    public Shop (String name, Queue queue){
        this.name = name;

        this.queue = queue;
    }

    public String getName() {
        return name;
    }

    public Queue getQueue() {
        return queue;
    }

    @Override
    public String toString() {
        return "Shop "+name;
    }
}
