package by.it.kameisha.jd02_01;

import java.util.HashMap;

public class PriceListRepo {
    private final HashMap<String, Integer> priceList;

    public PriceListRepo(HashMap<String, Integer> priceList) {
        this.priceList = priceList;
    }

    public HashMap<String, Integer> getPriceList() {
        return priceList;
    }
}
