package by.it.ragach.jd02_01.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    Map<String,Double> cart=  new HashMap<>();

 public void addGoods (String name, double price){
     cart.put(name,price);

 }

   public int size(){
     return cart.size();
    }
}
