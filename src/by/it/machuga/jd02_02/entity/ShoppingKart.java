package by.it.machuga.jd02_02.entity;

import by.it.machuga.jd02_02.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class ShoppingKart {
    private final List<Good> goods;

    public ShoppingKart() {
        this.goods = new ArrayList<>();
    }

    public void addGoodToCart(Good good) {
        goods.add(good);
    }

    public int getGoodsCount() {
        return goods.size();
    }

    @Override
    public String toString() {
        return Constants.GOODS + goods;
    }
}
