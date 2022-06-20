package by.it.kameisha.jd02_03;

import by.it.kameisha.jd02_03.entity.Manager;
import by.it.kameisha.jd02_03.entity.Queue;
import by.it.kameisha.jd02_03.entity.Shop;
import by.it.kameisha.jd02_03.repository.PriceListRepository;
import by.it.kameisha.jd02_03.service.ShopWorker;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue martInnQueue = new Queue();
        PriceListRepository repository = new PriceListRepository();
        Shop shop = new Shop("MartInn", martInnQueue, manager, repository);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
