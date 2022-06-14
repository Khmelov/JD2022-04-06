package by.it.marchenko.jd02_02.interfaces;

import java.util.Map;

public interface StockAction {
    Map<Integer, Integer> getStockRepo();

    int getStockSize();

    int getOccupiedPlace();

    boolean getFromStock(int id);

    void addGoodIDToStock(int id, int amount);
}
