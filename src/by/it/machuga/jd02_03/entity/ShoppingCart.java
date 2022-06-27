package by.it.machuga.jd02_03.entity;

import by.it.machuga.jd02_03.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Good> goods;

    public ShoppingCart() {
        this.goods = new ArrayList<>();
    }

    public void addGoodToCart(Good good) {
        goods.add(good);
    }

    public int getGoodsCount() {
        return goods.size();
    }

    public List<Good> getGoods() {
        return goods;
    }

    @Override
    public String toString() {
        return Constants.GOODS + goods;
    }
}
