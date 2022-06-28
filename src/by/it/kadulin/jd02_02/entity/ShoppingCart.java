package by.it.kadulin.jd02_02.entity;

import java.util.*;

public class ShoppingCart {

    public ShoppingCart() {
        goods = new ArrayList<>();
    }

    private int capacityCart;
    private final List<Good> goods;

    public int getCapacityCart() {
        return capacityCart;
    }

    public int getAmountGoods() {
        return goods.size();
    }

    public List<Good> getListGoods() {
        return goods;
    }

    public int addToCart(Good good) {
        goods.add(good);
        return goods.size();
    }

}
