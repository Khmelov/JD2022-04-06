package by.it.smirnov.jd02_02;

import by.it.smirnov.jd02_02.entities.Manager;
import by.it.smirnov.jd02_02.entities.Store;
import by.it.smirnov.jd02_02.entities.StoreQueue;
import by.it.smirnov.jd02_02.services.StoreWorker;

import static by.it.smirnov.jd02_02.repo.Wordings.STORE_01;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        StoreQueue storeQueue = new StoreQueue();
        Store store = new Store(STORE_01, storeQueue, manager);
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();
    }
}
