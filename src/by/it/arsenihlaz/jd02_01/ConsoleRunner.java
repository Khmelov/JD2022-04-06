package by.it.arsenihlaz.jd02_01;

public class ConsoleRunner {
    public static void main(String[] args) {
        Shop shop = new Shop("Santa");
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
