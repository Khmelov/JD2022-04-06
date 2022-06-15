package by.it.annazhegulovich.jd02_02.entity;

public class Store {
private final String name;
private final Queue queue;
private final Manager manager;

    public Store(String name, Queue deque, Manager manager) {
        this.name = name;
        this.queue = deque;
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }


    @Override
    public String toString() {
        return "Store " + name;
    }

    public String getName() {
        return name;
    }

    public Queue getQueue() {
        return queue;
    }
}
