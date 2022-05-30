package by.it.machuga.jd02_01.util;

import by.it.machuga.jd02_01.entity.Good;
import by.it.machuga.jd02_01.repository.PriceListRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChoiseHelper {
    private ChoiseHelper() {
    }
    public static Good getRandomGood(PriceListRepo priceListRepo){
        Map<Good, Double> priceList = priceListRepo.getPriceList();
        List<Good>goods= new ArrayList<>(priceList.keySet());
        Good good=goods.get(RandomGenerator.getRandomInt(goods.size()-1));
        return good;
    }
}
