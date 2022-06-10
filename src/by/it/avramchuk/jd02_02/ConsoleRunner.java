package by.it.avramchuk.jd02_02;

import by.it.avramchuk.jd02_02.entity.Shop;
import by.it.avramchuk.jd02_02.services.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        Shop shop = new Shop("Market");
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
