package by.it.marchenko.jd02_03.services;

import by.it.marchenko.jd02_03.exception.StoreException;
import by.it.marchenko.jd02_03.repository.GoodRepo;
import by.it.marchenko.jd02_03.repository.PriceListRepo;
import by.it.marchenko.jd02_03.repository.StockRepo;
import by.it.marchenko.jd02_03.utility.RandomGenerator;

import static by.it.marchenko.jd02_02.constants.StockConstant.*;
import static by.it.marchenko.jd02_02.constants.StoreExceptionConstant.GOOD_WORKER_WAS_INTERRUPTED;

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
        try {
            goodWorker.join();
        } catch (InterruptedException e) {
            throw new StoreException(GOOD_WORKER_WAS_INTERRUPTED, e);
        }
    }

    private void initStock(int goodsPositionCount) {
        for (int goodIndex = 0; goodIndex < goodsPositionCount; goodIndex++) {
            int goodQuantity = RandomGenerator.getRandom(MAX_QUANTITY_VALUE);
            stockRepo.addGoodIDToStock(goodIndex, goodQuantity);
        }
    }
}