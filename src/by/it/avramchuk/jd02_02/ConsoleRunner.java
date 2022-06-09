package by.it.avramchuk.jd02_02;

public class ConsoleRunner {
    public static void main(String[] args) {
        Shop shop = new Shop("Market");
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
