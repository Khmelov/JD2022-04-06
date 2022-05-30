package by.it.arsenihlaz.jd02_01;

import java.util.HashMap;

import java.util.Map;

public class PriceListRepo extends Good{
    Map<String, Double> goods = new HashMap<>();{
        goods.put("bread", 2.2);
        goods.put("milk", 1.5);
        goods.put("pizza", 8.5);
        goods.put("ice-cream", 1.2);
        goods.put("tomatoes", 9.0);
    }

    public PriceListRepo(String name, double price, Map<String, Double> goods) {
        super(name, price);
        this.goods = goods;
    }

    public Map<String, Double> getGoods() {
        return goods;
    }
}
