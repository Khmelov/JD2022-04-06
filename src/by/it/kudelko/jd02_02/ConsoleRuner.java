package by.it.kudelko.jd02_02;

import by.it.kudelko.jd02_02.entity.Manager;
import by.it.kudelko.jd02_02.entity.Queue;
import by.it.kudelko.jd02_02.entity.Shop;
import by.it.kudelko.jd02_02.service.ShopWorker;

public class ConsoleRuner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue euroMarketQueue = new Queue();
        Shop shop = new Shop("EuroMarket", euroMarketQueue, manager);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();

    }
}
