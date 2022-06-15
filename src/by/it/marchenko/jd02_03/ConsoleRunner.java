package by.it.marchenko.jd02_03;

import by.it.marchenko.jd02_03.models.Manager;
import by.it.marchenko.jd02_03.models.Store;
import by.it.marchenko.jd02_03.models.StoreQueue;
import by.it.marchenko.jd02_03.repository.GoodRepo;
import by.it.marchenko.jd02_03.repository.PriceListRepo;
import by.it.marchenko.jd02_03.repository.StockRepo;
import by.it.marchenko.jd02_03.services.ManagerWorker;
import by.it.marchenko.jd02_03.services.StoreWorker;

import static by.it.marchenko.jd02_02.constants.StoreConstant.MANAGER_NAME;
import static by.it.marchenko.jd02_02.constants.StoreConstant.STORE_NAME;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer(System.out);

        Manager manager = new Manager(MANAGER_NAME);
        ManagerWorker managerWorker = new ManagerWorker(manager);

        StoreQueue storeQueue = new StoreQueue();
        Store store = new Store(STORE_NAME, storeQueue, managerWorker);

        StockRepo stockRepo = new StockRepo();
        GoodRepo goodRepo = new GoodRepo();
        PriceListRepo priceRepo = new PriceListRepo();

        StoreWorker storeWorker = new StoreWorker(store, stockRepo,
                goodRepo, priceRepo, printer);
        storeWorker.start();
    }
}
