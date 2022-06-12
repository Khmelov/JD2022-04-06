package by.it.smirnov.jd02_02;

import by.it.smirnov.jd02_02.entities.Manager;
import by.it.smirnov.jd02_02.entities.Store;
import by.it.smirnov.jd02_02.entities.StoreQueue;
import by.it.smirnov.jd02_02.services.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        StoreQueue storeQueue = new StoreQueue();
        Store store = new Store("\"Wall of Sound musical gear\"", storeQueue, manager);
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();
    }
}
