package by.it.smirnov.jd02_01;

public class Runner {
    public static void main(String[] args) {
        Store store = new Store("\"Musical Gear\"");
        StoreWorker storeWorker = new StoreWorker(store);
        storeWorker.start();
    }
}
