package by.it.marchenko.jd02_03.utility;

import by.it.marchenko.jd02_03.repository.PriceListRepo;
import by.it.marchenko.jd02_03.repository.StockRepo;

import java.util.Map;
import java.util.Set;

public class StockAuditor {
    private final StockRepo stockRepo;
    private final PriceListRepo priceListRepo;

    public StockAuditor(StockRepo stockRepo, PriceListRepo priceListRepo) {
        this.stockRepo = stockRepo;
        this.priceListRepo = priceListRepo;
    }

    public double checkStockBalance() {
        Map<Integer, Integer> goodCounts = stockRepo.getStockRepo();
        Set<Map.Entry<Integer, Integer>> entries = goodCounts.entrySet();
        double stockBalance = 0d;
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer goodID = entry.getKey();
            Integer count = entry.getValue();
            double price = priceListRepo.getPrice(goodID);
            stockBalance += count * price;
        }
        return stockBalance;
    }
}
