package by.it.arsenihlaz.jd02_02.entity;

import by.it.arsenihlaz.jd02_02.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceListRepo {
    private static final Map<String, Double> goods = new HashMap<>();

    static {
        goods.put("bread", 2.20);
        goods.put("milk", 1.45);
        goods.put("pizza", 8.90);
        goods.put("ice-cream", 2.15);
        goods.put("tomatoes", 9.50);
        goods.put("potatoes", 0.75);
        goods.put("green peas", 2.65);
        goods.put("buckwheat grain", 3.80);
        goods.put("rice", 2.99);
        goods.put("eggs", 3.25);

    }

    public static String getRandomGoods() {
        List<String> goodsList = new ArrayList<>(goods.keySet());
        int randomIndex = RandomGenerator.get(0, goodsList.size()-1);
        String randomGoods = goodsList.get(randomIndex);
        return randomGoods;
    }

    public static double getPrice(String nameGoods) {
        return goods.get(nameGoods);
    }

}
