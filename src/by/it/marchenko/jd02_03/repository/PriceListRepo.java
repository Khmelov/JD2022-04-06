package by.it.marchenko.jd02_03.repository;

import by.it.marchenko.jd02_03.interfaces.PriceListAction;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo implements PriceListAction {

    private final Map<Integer, Double> priceList = new HashMap<>();

    @Override
    public double getPrice(int id) {
        return priceList.get(id);
    }

    @Override
    public void setPrice(int id, double price) {
        priceList.put(id, price);
    }
}
