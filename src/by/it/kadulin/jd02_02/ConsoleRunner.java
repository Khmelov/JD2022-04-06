package by.it.kadulin.jd02_02;

import by.it.kadulin.jd02_02.entity.Manager;
import by.it.kadulin.jd02_02.entity.Queue;
import by.it.kadulin.jd02_02.entity.Shop;
import by.it.kadulin.jd02_02.service.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Queue euroMarketQueue = new Queue();
        Shop shopEu = new Shop("EuroMarket", euroMarketQueue, manager);
        ShopWorker shopWorkerEu = new ShopWorker(shopEu);
        shopWorkerEu.start();

//        Queue deMarketQueue = new Queue();
//        Shop shopDe = new Shop("DeMarket", deMarketQueue);
//        ShopWorker shopWorkerDe = new ShopWorker(shopDe);
//        shopWorkerDe.start();
    }
}
