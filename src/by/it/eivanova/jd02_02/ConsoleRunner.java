package by.it.eivanova.jd02_02;

import by.it.eivanova.jd02_02.entity.Manager;
import by.it.eivanova.jd02_02.entity.ShopQueue;
import by.it.eivanova.jd02_02.entity.Shop;
import by.it.eivanova.jd02_02.service.ShopWorker;

public class ConsoleRunner {


    public static void main(String[] args) {
        //  for (int i = 0; i < 100; i++) {
        Manager manager = new Manager(100);
        ShopQueue euroMarketQueue = new ShopQueue();
        Shop shop = new Shop("EuroMarket", euroMarketQueue, manager);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();

    }

}
