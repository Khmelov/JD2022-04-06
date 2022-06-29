package by.it.eivanova.jd02_02.respository;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepository {

    public static Map<String, Double> priceList = new HashMap<>();
    static {
        priceList.put("cheese",3.50);
        priceList.put("wine", 12.0);
        priceList.put("prawns", 20.5);
        priceList.put("water",0.5);
        priceList.put("salmon", 18.5);
        priceList.put("rice", 2.0);
    }

}
