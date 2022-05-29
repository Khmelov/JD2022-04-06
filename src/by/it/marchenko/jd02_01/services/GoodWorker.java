package by.it.marchenko.jd02_01.services;

import by.it.marchenko.jd02_01.models.Good;
import by.it.marchenko.jd02_01.repository.GoodRepo;
import by.it.marchenko.jd02_01.repository.PriceListRepo;
import by.it.marchenko.jd02_01.repository.StockRepo;
import by.it.marchenko.jd02_01.utility.RandomGenerator;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static by.it.marchenko.jd02_01.constants.GoodConstants.MAX_GOOD_PRICE;
import static by.it.marchenko.jd02_01.constants.GoodConstants.MIN_GOOD_PRICE;

public class GoodWorker extends Thread {
    private final GoodRepo goodRepo;
    private final StockRepo stockRepo;
    private final PriceListRepo priceListRepo;

    private Set<Good> goodsSet;

    public GoodWorker(GoodRepo goodRepo, StockRepo stockRepo, PriceListRepo priceListRepo) {
        this.stockRepo = stockRepo;
        this.goodRepo = goodRepo;
        this.priceListRepo = priceListRepo;
    }

    @Override
    public void run() {
        initGood();

        for (Good good : goodsSet) {
            System.out.println(good.toFormatString());
        }
    }

    private void initGood() {
        int goodIDAmount = stockRepo.getGoodIDAmount();
        goodsSet = new HashSet<>(goodIDAmount);
        Map<Integer, Integer> stockRepo = this.stockRepo.getStockRepo();
        Set<Map.Entry<Integer, Integer>> entries = stockRepo.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer goodID = entry.getKey();
            String goodName = String.format("Good #%-3d", goodID);
            goodRepo.addName(goodID, goodName);
            double price = RandomGenerator.getRandom(MIN_GOOD_PRICE, MAX_GOOD_PRICE) / 100.0;
            priceListRepo.setPrice(goodID, price);
            Good good = new Good(goodID, goodName, price);
            goodsSet.add(good);
        }
    }


    @SuppressWarnings("unused")
    public Set<Good> getGoodsSet() {
        return new HashSet<>(goodsSet);
    }

    @SuppressWarnings("unused")
    public Good findGoodFromID(int id) {
        return null;//return goodsSet.
    }

}
