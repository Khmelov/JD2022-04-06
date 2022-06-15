package by.it.avramchuk.jd02_02;

import by.it.avramchuk.jd02_02.entity.Manager;
import by.it.avramchuk.jd02_02.entity.Shop;
import by.it.avramchuk.jd02_02.entity.ShopQueue;
import by.it.avramchuk.jd02_02.services.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        ShopQueue marketQueue = new ShopQueue();
        Shop shop = new Shop("Market", marketQueue);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
