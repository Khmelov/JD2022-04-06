package by.it.ragach.jd02_02.entity;

import by.it.ragach.jd02_02.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceListRepo {
    private static final Map<String, Double> goods = new HashMap<>();

    static {
        goods.put("cheese", 3.5);
        goods.put("water", 2.4);
        goods.put("cucumber", 6.85);
        goods.put("melon", 9.2);
        goods.put("bananas", 5.3);
        goods.put("pears", 4.65);
        goods.put("tomatoes", 5.4);
        goods.put("cabbage",5.85);
        goods.put("cherries",8.75);
        goods.put("lemon", 2.45);


    }
    public static String getGoodName(){
        List<String>goodsList = new ArrayList<>(goods.keySet());
        int randomGoodNumber = RandomGenerator.get(0,goodsList.size()-1);
        return goodsList.get(randomGoodNumber);
    }

    public static double getPrice(String nameGoods){
        return goods.get(nameGoods);

    }

}
