package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.models.Good;
import by.it.marchenko.jd02_02.repository.GoodRepo;
import by.it.marchenko.jd02_02.repository.PriceListRepo;
import by.it.marchenko.jd02_02.repository.StockRepo;
import by.it.marchenko.jd02_02.utility.RandomGenerator;

import java.util.Map;
import java.util.Set;

import static by.it.marchenko.jd02_02.constants.GoodConstants.*;

public class GoodWorker extends Thread {

    private final GoodRepo goodRepo;
    private final StockRepo stockRepo;
    private final PriceListRepo priceListRepo;

    //private Set<Good> goodsSet;

    public GoodWorker(GoodRepo goodRepo, StockRepo stockRepo, PriceListRepo priceListRepo) {
        this.stockRepo = stockRepo;
        this.goodRepo = goodRepo;
        this.priceListRepo = priceListRepo;
    }

    @Override
    public void run() {
        initGood();

        //for (Good good : goodsSet) {
        //    System.out.println(good.toFormatString());
        //}
    }

    private void initGood() {
        //int goodIDAmount = stockRepo.getGoodIDAmount();
        //goodsSet = new HashSet<>(goodIDAmount);
        Map<Integer, Integer> stockRepo = this.stockRepo.getStockRepo();
        Set<Map.Entry<Integer, Integer>> entries = stockRepo.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer goodID = entry.getKey();
            String goodName = String.format("Good #%d", goodID);
            goodRepo.addName(goodID, goodName);
            double price = RandomGenerator.getRandom(MIN_GOOD_PRICE, MAX_GOOD_PRICE) / (double) CENT_IN_DOLLAR;
            priceListRepo.setPrice(goodID, price);
            //Good good = new Good(goodID, goodName, price);
            //goodsSet.add(good);
        }
    }

    public Good findGoodFromID(int id) {
        String name = goodRepo.getName(id);
        double price = priceListRepo.getPrice(id);
        return new Good(id, name, price);
    }

}
