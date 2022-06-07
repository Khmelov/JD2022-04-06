package by.it.marchenko.jd02_02.models;

import by.it.marchenko.jd02_02.constants.StoreConstant;
import by.it.marchenko.jd02_02.services.ManagerWorker;

import static by.it.marchenko.jd02_02.constants.StoreConstant.STORE;

public class Store {
    private static int startID = StoreConstant.STORE_START_ID;

    private final int id;
    private final String name;
    private final StoreQueue storeQueue;
    private final ManagerWorker managerWorker;

    public Store(String name, StoreQueue storeQueue, ManagerWorker managerWorker) {
        this.name = name;
        this.managerWorker = managerWorker;
        this.id = startID++;
        this.storeQueue = storeQueue;
    }

    public Manager getManager() {
        return managerWorker.getManager();
    }

    public ManagerWorker getManagerWorker() {
        return managerWorker;
    }

    public StoreQueue getStoreQueue() {
        return storeQueue;
    }

    public Object getMonitor() {
        return storeQueue;
    }

    @Override
    public String toString() {
        return String.format("%s %s #%d", STORE, name, id);
    }
}
