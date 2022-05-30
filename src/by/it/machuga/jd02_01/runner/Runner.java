package by.it.machuga.jd02_01.runner;

import by.it.machuga.jd02_01.entity.Store;
import by.it.machuga.jd02_01.service.StoreWorker;

import java.util.Date;

public class Runner {
    public static void main(String[] args) {
        Store spar = new Store("Spar");
        StoreWorker storeWorker = new StoreWorker(spar);
        storeWorker.start();
    }
}
