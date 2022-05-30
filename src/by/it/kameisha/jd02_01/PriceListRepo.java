package by.it.kameisha.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepo {
    private Map<String, Integer> priceList = new HashMap<>();

    public PriceListRepo(Map<String, Integer> priceList) {
        this.priceList = priceList;
    }

    public Integer getPrice(String key){
        return priceList.get(key);
    }
}
