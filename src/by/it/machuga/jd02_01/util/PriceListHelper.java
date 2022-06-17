package by.it.machuga.jd02_01.util;

import by.it.machuga.jd02_01.entity.Good;

import java.util.Map;

public class PriceListHelper {

    public static void fillPriceList(Map<Good, Double> priceList) {
        int priceListSize = RandomGenerator.getRandomInt(Constants.MIN_PRICE_LIST_SIZE, Constants.MAX_PRICE_LIST_SIZE);
        for (int i = 0; i < priceListSize; i++) {
            Good good = new Good(RandomGenerator.getRandomText(Constants.GOOD_NAME_LENGTH));
            double price = RandomGenerator.getRandomDouble(Constants.MIN_PRICE, Constants.MAX_PRICE);
            priceList.put(good, price);
        }
    }
}
