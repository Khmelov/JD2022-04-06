package by.it.marchenko.jd02_01.repository;

import by.it.marchenko.jd02_01.interfaces.StockAction;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StockRepo implements StockAction {
    private final Map<Integer, Integer> stockRepo = new HashMap<>();

    @Override
    public void addGoodIDToStock(int id, int amount) {
        if (stockRepo.containsKey(id)) {
            stockRepo.put(id, amount + stockRepo.get(id));
        } else {
            stockRepo.put(id, amount);
        }
        //return stockRepo.get(id);
    }

    @Override
    public int getAmountOfGood(int id) {
        return stockRepo.get(id);
    }

    public Map<Integer, Integer> getStockRepo() {
        return new HashMap<>(stockRepo);
    }

    @Override
    public int getOccupiedPlace() {
        Set<Map.Entry<Integer, Integer>> entries = stockRepo.entrySet();
        int occupiedPlace = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            occupiedPlace += entry.getValue();
        }
        return occupiedPlace;
    }

    @Override
    public int getGoodIDAmount() {
        return stockRepo.size();
    }

    @Override
    public boolean getFromStock(int id) {
        int recentAtStock = stockRepo.get(id);
        if (recentAtStock > 0) {
            stockRepo.replace(id, recentAtStock - 1);
            // TODO implement remove good from stock if recentAtStock=0
            return true;
        }
        return false;
    }


}
