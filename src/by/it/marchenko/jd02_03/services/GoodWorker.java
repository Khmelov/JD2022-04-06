package by.it.marchenko.jd02_03.services;

import by.it.marchenko.jd02_03.models.Good;
import by.it.marchenko.jd02_03.repository.GoodRepo;
import by.it.marchenko.jd02_03.repository.PriceListRepo;
import by.it.marchenko.jd02_03.repository.StockRepo;
import by.it.marchenko.jd02_03.utility.RandomGenerator;

import java.util.Map;
import java.util.Set;

import static by.it.marchenko.jd02_02.constants.GoodConstants.*;

public class GoodWorker extends Thread {

    private final GoodRepo goodRepo;
    private final StockRepo stockRepo;
    private final PriceListRepo priceListRepo;

    public GoodWorker(GoodRepo goodRepo, StockRepo stockRepo, PriceListRepo priceListRepo) {
        this.stockRepo = stockRepo;
        this.goodRepo = goodRepo;
        this.priceListRepo = priceListRepo;
    }

    @Override
    public void run() {
        Map<Integer, Integer> stockRepo = this.stockRepo.getStockRepo();
        Set<Map.Entry<Integer, Integer>> entries = stockRepo.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer goodID = entry.getKey();
            String goodName = String.format(GOOD_NAME_FORMAT, goodID);
            double price =
                    RandomGenerator.getRandom(MIN_GOOD_PRICE, MAX_GOOD_PRICE) / (double) CENT_IN_DOLLAR;
            goodRepo.setName(goodID, goodName);
            priceListRepo.setPrice(goodID, price);
        }
    }

    public Good findGoodFromID(int id) {
        String name = goodRepo.getName(id);
        double price = priceListRepo.getPrice(id);
        return new Good(id, name, price);
    }
}
