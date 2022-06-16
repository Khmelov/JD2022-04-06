package by.it.machuga.jd02_02.runner;

import by.it.machuga.jd02_02.entity.Good;
import by.it.machuga.jd02_02.entity.Manager;
import by.it.machuga.jd02_02.entity.Queue;
import by.it.machuga.jd02_02.entity.Store;
import by.it.machuga.jd02_02.repository.PriceListRepo;
import by.it.machuga.jd02_02.service.StoreWorker;
import by.it.machuga.jd02_02.util.Constants;
import by.it.machuga.jd02_02.util.PriceListHelper;

import java.util.HashMap;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {
        Map<Good, Double> priceList = new HashMap<>();
        PriceListHelper.fillPriceList(priceList);
        PriceListRepo priceListRepo = new PriceListRepo(priceList);
        Queue queue = new Queue();
        Manager manager = new Manager(Constants.PLAN_QUANTITY_CUSTOMER);
        Store spar = new Store(Constants.SHOP_NAME, priceListRepo, queue, manager);
        StoreWorker storeWorker = new StoreWorker(spar);
        storeWorker.start();
    }
}
