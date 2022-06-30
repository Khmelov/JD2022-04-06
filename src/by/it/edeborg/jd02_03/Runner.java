package by.it.edeborg.jd02_03;


import by.it.edeborg.jd02_03.organization.Manager;
import by.it.edeborg.jd02_03.organization.Queue;
import by.it.edeborg.jd02_03.organization.Shop;
import by.it.edeborg.jd02_03.repository.PriceListRepository;
import by.it.edeborg.jd02_03.service.ShopWorker;

public class Runner {
    public static void main(String[] args){
        Manager manager = new Manager (100);
        Queue martInnQueue = new Queue();
        PriceListRepository repository = new PriceListRepository();
        Shop shop = new Shop("MartInn", martInnQueue, manager, repository);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
            }
        }


