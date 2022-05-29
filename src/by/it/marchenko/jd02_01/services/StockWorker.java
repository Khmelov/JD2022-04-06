package by.it.marchenko.jd02_01.services;

import by.it.marchenko.jd02_01.repository.GoodRepo;
import by.it.marchenko.jd02_01.repository.PriceListRepo;
import by.it.marchenko.jd02_01.repository.StockRepo;
import by.it.marchenko.jd02_01.utility.RandomGenerator;

import static by.it.marchenko.jd02_01.constants.StockConstant.*;

public class StockWorker extends Thread {

    private final StockRepo stockRepo;
    private final GoodRepo goodRepo;
    private final PriceListRepo priceRepo;

    public StockWorker(StockRepo stockRepo, GoodRepo goodRepo, PriceListRepo priceRepo) {
        this.stockRepo = stockRepo;
        this.goodRepo = goodRepo;
        this.priceRepo = priceRepo;
    }

    @Override
    public void run() {
        int goodsPositionCount = RandomGenerator.getRandom(MIN_GOODS_POSITION, MAX_GOODS_POSITION);
        initStock(goodsPositionCount);
        GoodWorker goodWorker = new GoodWorker(goodRepo, stockRepo, priceRepo);
        goodWorker.start();

    }

    private void initStock(int goodsPositionCount) {
        for (int goodIndex = 0; goodIndex < goodsPositionCount; goodIndex++) {
            int goodQuantity = RandomGenerator.getRandom(MAX_QUANTITY_VALUE);
            stockRepo.addGoodIDToStock(goodIndex, goodQuantity);
        }
    }
}
