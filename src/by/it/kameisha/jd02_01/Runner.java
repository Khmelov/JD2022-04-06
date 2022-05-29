package by.it.kameisha.jd02_01;

public class Runner {
    public static void main(String[] args) {
        Shop shop = new Shop("MartInn");
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
