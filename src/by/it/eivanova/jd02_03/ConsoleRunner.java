package by.it.eivanova.jd02_03;

import by.it._classwork_.jd02_03.entity.Queue;
import by.it.eivanova.jd02_03.entity.Manager;
import by.it.eivanova.jd02_03.entity.Shop;
import by.it.eivanova.jd02_03.entity.ShopQueue;
import by.it.eivanova.jd02_03.service.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        ShopQueue marketQueue = new ShopQueue();
        Manager manager = new Manager(100);
        Shop shop = new Shop("Market", marketQueue, manager);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
