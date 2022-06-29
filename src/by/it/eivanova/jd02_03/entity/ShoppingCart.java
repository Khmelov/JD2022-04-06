package by.it.eivanova.jd02_03.entity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public List<Good> goodsInCart;

    public ShoppingCart(){
    this.goodsInCart = new ArrayList<>();
    }

    public List<Good> getGoodsInCart(){
        return goodsInCart;
    }

    public int addGoodToCart(Good good){
        goodsInCart.add(good);
        return goodsInCart.size();
    }
}
