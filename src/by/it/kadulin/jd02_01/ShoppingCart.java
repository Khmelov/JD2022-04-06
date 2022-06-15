package by.it.kadulin.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    public int getCapacityCart() {
        return capacityCart;
    }

    public int getAmountGoods() {
        return goods.size();
    }

    public int addToCart(String name, double price) {
        goods.put(name, price);
        return goods.size();
    }



    private int capacityCart;
    private final Map<String, Double> goods = new HashMap<>();

    public ShoppingCart() {

    }
}
