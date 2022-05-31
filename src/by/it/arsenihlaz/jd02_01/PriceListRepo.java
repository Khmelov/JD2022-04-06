package by.it.arsenihlaz.jd02_01;

import java.util.*;

public class PriceListRepo {
    private static final Map<String, Double> goods = new HashMap<>();

    static {
        goods.put("bread", 2.2);
        goods.put("milk", 1.45);
        goods.put("pizza", 8.9);
        goods.put("ice-cream", 2.15);
        goods.put("tomatoes", 9.5);
        goods.put("potatoes", 0.75);
        goods.put("green peas", 2.65);
    }

    public static String getRandomGoods() {
        List<String> goodsList = new ArrayList<String>(goods.keySet());
        int randomIndex = RandomGenerator.get(0, goodsList.size()-1);
        String randomGoods = goodsList.get(randomIndex);
        return randomGoods;
    }

    public static double getPrice(String nameGoods) {
        return goods.get(nameGoods);
    }

}
