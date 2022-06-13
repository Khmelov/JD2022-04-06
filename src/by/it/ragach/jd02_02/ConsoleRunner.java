package by.it.ragach.jd02_02;

import by.it.ragach.jd02_02.entity.Shop;
import by.it.ragach.jd02_02.service.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        Shop shop = new Shop("EuroMarket");
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();

    }
}
