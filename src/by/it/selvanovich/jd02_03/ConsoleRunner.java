package by.it.selvanovich.jd02_03;

import by.it.selvanovich.jd02_03.entity.Manager;
import by.it.selvanovich.jd02_03.entity.Queue;
import by.it.selvanovich.jd02_03.entity.Shop;
import by.it.selvanovich.jd02_03.service.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {

        Manager manager = new Manager(1000);
        Queue euroMarketQueue = new Queue();
        Shop shop = new Shop("EuroMarket", euroMarketQueue, manager);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }

}
