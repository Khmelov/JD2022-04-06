package by.it.ragach.jd02_02.entity;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    Map<String,Double> cart=  new HashMap<>();

 public int addGoods (String name, double price){
     cart.put(name,price);
     return cart.size();
 }

   public int size(){
     return cart.size();
    }
}
