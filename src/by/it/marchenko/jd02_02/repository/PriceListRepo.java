package by.it.marchenko.jd02_02.repository;

import by.it.marchenko.jd02_02.interfaces.PriceListAction;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo implements PriceListAction {

    private final Map<Integer, Double> priceList = new HashMap<>();

    @Override
    public void setPrice(int id, double price) {
        priceList.put(id, price);
    }

    @Override
    public double getPrice(int id) {
        return priceList.get(id);
    }

    public Map<Integer, Double> getPriceList() {
        return new HashMap<>(priceList);
    }
}
