package by.it.marchenko.jd02_01;

import by.it.marchenko.jd02_01.models.Store;
import by.it.marchenko.jd02_01.workers.StoreWorker;

public class ConsoleRunner {
    public static void main(String[] args) {

        Printer printer = new Printer(System.out);
        Store store = new Store("BestStore", 1);
        StoreWorker storeWorker = new StoreWorker(printer, store);
        storeWorker.start();
    }
}
