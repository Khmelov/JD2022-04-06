package by.it.kadulin.jd02_01;

public class ConsoleRunner {
    public static void main(String[] args) {
        Shop shop = new Shop("EuroMarket");
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
