package by.it.kameisha.jd02_02;

public class Runner {
    public static void main(String[] args) {
        PriceListRepository repository = new PriceListRepository();
        Shop shop = new Shop("MartInn");
        ShopWorker shopWorker = new ShopWorker(shop, repository);
        shopWorker.start();
    }
}
