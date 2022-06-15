package by.it.marchenko.jd02_03.models;

import by.it.marchenko.jd02_03.services.ManagerWorker;

import static by.it.marchenko.jd02_02.constants.StoreConstant.STORE;
import static by.it.marchenko.jd02_02.constants.StoreConstant.STORE_START_ID;

public class Store {
    private static int startID = STORE_START_ID;

    private final int id;
    private final String name;
    private final StoreQueue storeQueue;
    private final ManagerWorker managerWorker;

    public Store(String name, StoreQueue storeQueue, ManagerWorker managerWorker) {
        this.id = startID++;
        this.name = name;
        this.managerWorker = managerWorker;
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
