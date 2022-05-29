package by.it.marchenko.jd02_01.services;

import by.it.marchenko.jd02_01.repository.GoodRepo;
import by.it.marchenko.jd02_01.repository.PriceListRepo;
import by.it.marchenko.jd02_01.repository.StockRepo;
import by.it.marchenko.jd02_01.utility.RandomGenerator;

public class StockWorker extends Thread {
    public static final int MAX_QUANTITY_VALUE = 20;
    public static final int MAX_GOODS_POSITION = 15;
    public static final int MIN_GOODS_POSITION = 8;

    //private final StoreStock stock;
    private final StockRepo stockRepo;
    private final GoodRepo goodRepo;
    private final PriceListRepo priceRepo;

    public StockWorker(StockRepo stockRepo, GoodRepo goodRepo, PriceListRepo priceRepo) {
        //this.stock = stock;
        this.stockRepo = stockRepo;
        this.goodRepo = goodRepo;
        this.priceRepo = priceRepo;
    }

    @Override
    public void run() {
        int goodsPositionCount = RandomGenerator.getRandom(MIN_GOODS_POSITION, MAX_GOODS_POSITION);
        initStock(goodsPositionCount);
        printStock();
        GoodWorker goodWorker = new GoodWorker(goodRepo, stockRepo, priceRepo);
        goodWorker.start();

    }

    private void initStock(int goodsPositionCount) {
        for (int goodIndex = 1; goodIndex <= goodsPositionCount; goodIndex++) {
            int goodQuantity = RandomGenerator.getRandom(MAX_QUANTITY_VALUE);
            stockRepo.addGoodIDToStock(goodIndex, goodQuantity);
        }
    }

    private void printStock() {
        //out.
        System.out.println(stockRepo.getStockRepo());
    }
}
