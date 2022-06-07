package by.it.marchenko.jd02_02;

import by.it.marchenko.jd02_02.models.Manager;
import by.it.marchenko.jd02_02.models.Store;
import by.it.marchenko.jd02_02.models.StoreQueue;
import by.it.marchenko.jd02_02.repository.GoodRepo;
import by.it.marchenko.jd02_02.repository.PriceListRepo;
import by.it.marchenko.jd02_02.repository.StockRepo;
import by.it.marchenko.jd02_02.services.ManagerWorker;
import by.it.marchenko.jd02_02.services.StoreWorker;

public class ConsoleRunner {
    public static final String STORE_NAME = "Green";
    public static final String MANAGER_NAME = "Ivan Drago";


    public static void main(String[] args) {
        Printer printer = new Printer(System.out);
        Manager manager = new Manager(MANAGER_NAME);

        ManagerWorker managerWorker = new ManagerWorker(manager);

        StoreQueue storeQueue = new StoreQueue();
        Store store = new Store(STORE_NAME, storeQueue, managerWorker);
        StockRepo stockRepo = new StockRepo();
        GoodRepo goodRepo = new GoodRepo();
        PriceListRepo priceRepo = new PriceListRepo();
        StoreWorker storeWorker = new StoreWorker(stockRepo, store,
                goodRepo, priceRepo, printer);

        storeWorker.start();
    }
}
