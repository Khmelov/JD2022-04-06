package by.it.avramchuk.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Good> goodsInCart;

    public ShoppingCart(){
        this.goodsInCart = new ArrayList<>();
    }

   public int addGoodToCart(Good good){
        goodsInCart.add(good);
        return goodsInCart.size();
   }
}
