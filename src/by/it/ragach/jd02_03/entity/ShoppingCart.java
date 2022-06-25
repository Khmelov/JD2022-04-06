package by.it.ragach.jd02_03.entity;



import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Customer customer;
    Map<String, Double> cart = new HashMap<>();

    public ShoppingCart (Customer customer) {
       this.customer = customer;
        this.cart = getCart();
    }

    public int addGoods(String name, double price) {
        cart.put(name,price);
        return cart.size();
    }

    public Map<String, Double> getCart() {
        return cart;
    }

    public int size() {
        return cart.size();
    }
}
