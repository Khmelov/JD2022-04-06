package by.it.avramchuk.jd02_03.repository;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepository {

    public static Map<String, Double> priceList = new HashMap<>();
    static {
        priceList.put("bread",1.50);
        priceList.put("milk", 2.0);
        priceList.put("salt", 0.7);
        priceList.put("butter",2.5);
        priceList.put("soap", 3.75);
        priceList.put("rope", 5.0);
    }

}
