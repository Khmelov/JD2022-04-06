package by.it.selvanovich.jd02_01;

public class ConsoleRunner {
    public static void main(String[] args) {
        Shop shop = new Shop("EuroMarket");
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();

        Shop shop2 = new Shop("Sosedi");
        ShopWorker shopWorker2 = new ShopWorker(shop2);
        shopWorker2.start();
    }

}
