package by.it.machuga.jd02_03.util;

import by.it.machuga.jd02_03.entity.Good;
import by.it.machuga.jd02_03.repository.PriceListRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChooseHelper {
    private ChooseHelper() {
    }

    public static Good getRandomGood(PriceListRepo priceListRepo) {
        Map<Good, Double> priceList = priceListRepo.getPriceList();
        List<Good> goods = new ArrayList<>(priceList.keySet());
        return goods.get(RandomGenerator.getRandomInt(goods.size() - 1));
    }
}
