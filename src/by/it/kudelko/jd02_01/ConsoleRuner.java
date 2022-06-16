package by.it.kudelko.jd02_01;

public class ConsoleRuner {
    public static void main(String[] args) {
        Shop shop = new Shop("EuroMarket");
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
