package by.it.ragach.jd02_02;

import by.it.ragach.jd02_02.entity.Queue;
import by.it.ragach.jd02_02.entity.Shop;
import by.it.ragach.jd02_02.service.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        Queue euroMarketQueue = new Queue();
        Shop shop = new Shop ("EuroMarket",euroMarketQueue);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();

    }
}
