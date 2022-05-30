package by.it.machuga.jd02_01.util;

import by.it.machuga.jd02_01.entity.Good;

import java.util.Map;

public class PriceListHelper {
    public static void fillPriceList(Map<Good, Double> priceList) {
        int priceListSize = RandomGenerator.getRandomInt(10, 100);
        for (int i = 0; i < priceListSize; i++) {
            Good good = new Good(RandomGenerator.getRandomText(4));
            double price = RandomGenerator.getRandomDouble(0.1, 100);
            priceList.put(good, price);
        }
    }
}
