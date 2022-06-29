package by.it.edeborg.jd02_01;

public class ConsoleRunner {
    public static void main(String[] args) {
        Shop shop = new Shop("GameWorkShop");
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}