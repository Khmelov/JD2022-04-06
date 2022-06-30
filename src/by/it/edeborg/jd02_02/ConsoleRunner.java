package by.it.edeborg.jd02_02;

import by.it.edeborg.jd02_02.organization.Manager;
import by.it.edeborg.jd02_02.organization.Queue;
import by.it.edeborg.jd02_02.organization.Shop;
import by.it.edeborg.jd02_02.service.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue GameWorkShopQueue = new Queue();
        Shop shop = new Shop("GameWorkShop", GameWorkShopQueue, manager);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();

    }
}
