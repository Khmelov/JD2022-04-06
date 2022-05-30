package by.it.machuga.jd02_01.repository;

import by.it.machuga.jd02_01.entity.Good;

import java.util.Map;
import java.util.StringJoiner;

public class PriceListRepo {
    private final Map<Good,Double>priceList;

    public PriceListRepo(Map<Good, Double> priceList) {
        this.priceList = priceList;
    }

    public Map<Good, Double> getPriceList() {
        return priceList;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Map.Entry<Good, Double> entry : priceList.entrySet()) {
            stringJoiner.add("Item: "+entry.getKey().getName()+" -> price: "+entry.getValue());
        }
        return stringJoiner.toString();
    }
}
