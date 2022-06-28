package by.it.machuga.jd02_01.runner;

import by.it.machuga.jd02_01.entity.Good;
import by.it.machuga.jd02_01.entity.Store;
import by.it.machuga.jd02_01.repository.PriceListRepo;
import by.it.machuga.jd02_01.service.StoreWorker;
import by.it.machuga.jd02_01.util.Constants;
import by.it.machuga.jd02_01.util.PriceListHelper;

import java.util.HashMap;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {
        Map<Good, Double> priceList = new HashMap<>();
        PriceListHelper.fillPriceList(priceList);
        PriceListRepo priceListRepo = new PriceListRepo(priceList);
        Store spar = new Store(Constants.SHOP_NAME, priceListRepo);
        StoreWorker storeWorker = new StoreWorker(spar);
        storeWorker.start();
    }
}
