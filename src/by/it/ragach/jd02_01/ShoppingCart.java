package by.it.ragach.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {


   private final Customer customer;
   private final Shop shop;
   private List<Good>shoppingCart;


    public ShoppingCart(Customer customer, Shop shop) {
        this.customer = customer;
        this.shop = shop;
        shoppingCart=new ArrayList<>();
    }
}
