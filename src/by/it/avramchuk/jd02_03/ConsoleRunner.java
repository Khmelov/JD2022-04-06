package by.it.avramchuk.jd02_03;

import by.it.avramchuk.jd02_03.entity.Manager;
import by.it.avramchuk.jd02_03.entity.Shop;
import by.it.avramchuk.jd02_03.entity.ShopQueue;
import by.it.avramchuk.jd02_03.services.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        ShopQueue marketQueue = new ShopQueue();
        Manager manager = new Manager(100);
        Shop shop = new Shop("Market", marketQueue, manager);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
