package by.it.smirnov.jd02_01;

import by.it.smirnov.jd02_01.entities.Store;
import by.it.smirnov.jd02_01.services.StoreWorker;

public class Runner {
    public static void main(String[] args) {
        Store store = new Store("\"Wall of Sound musical gear\"");
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();
    }
}
