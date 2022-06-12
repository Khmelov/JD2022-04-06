package by.it.kameisha.jd02_02;

import by.it.kameisha.jd02_02.entity.Shop;
import by.it.kameisha.jd02_02.repository.PriceListRepository;
import by.it.kameisha.jd02_02.service.ShopWorker;

public class Runner {
    public static void main(String[] args) {
        PriceListRepository repository = new PriceListRepository();
        Shop shop = new Shop("MartInn");
        ShopWorker shopWorker = new ShopWorker(shop, repository);
        shopWorker.start();
    }
}
