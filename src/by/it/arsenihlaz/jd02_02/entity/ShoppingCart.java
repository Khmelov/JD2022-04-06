package by.it.arsenihlaz.jd02_02.entity;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Customer customer;
    Map<String, Double> cart = new HashMap<>();

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.cart = getCart();
    }

    public void addGoods(String name, double price) {
        int count = 0;
        if (cart.containsKey(name)) {
            count++;
            String newName = name + " #" + count;
            cart.put(newName, price);
        } else cart.put(name, price);
    }

    public Map<String, Double> getCart() {
        return cart;
    }

    public int size() {
        return cart.size();
    }
}
