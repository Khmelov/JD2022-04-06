package by.it.kameisha.jd02_01;

import by.it.kameisha.jd01_14.Util;

import java.util.HashMap;
import java.util.Map;

public class PriceListRepository {
    public static final String PRICE_LIST_TXT = "PriceList.txt";
    private final Map<Good, Integer> priceList = new HashMap<>();

    public PriceListRepository() {
        String path = Util.getPath(PriceReader.class, PRICE_LIST_TXT);
        PriceReader priceReader = new PriceReader();
        priceReader.readPriceList(path);
    }

}
