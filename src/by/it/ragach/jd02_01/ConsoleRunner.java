package by.it.ragach.jd02_01;

import by.it.ragach.jd02_01.entity.Shop;
import by.it.ragach.jd02_01.service.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        Shop shop = new Shop("EuroMarket");
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();

    }
}
