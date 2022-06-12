package by.it.smirnov.jd02_02.entities;

public class Store {

    private final String name;
    private final StoreQueue storeQueue;

    public Manager getManager() {
        return manager;
    }

    private final Manager manager;

    public Store(String name, StoreQueue storeQueue, Manager manager) {
        this.name = name;
        this.storeQueue = storeQueue;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Store " + name;
    }

    public StoreQueue getStoreQueue() {
        return storeQueue;
    }
}
