package by.it.marchenko.jd02_01.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Good> shoppingCart;

    public ShoppingCart(int capacity) {
        shoppingCart = new ArrayList<>(capacity);
    }

    public int getSize() {
        return shoppingCart.size();
    }

    public List<Good> getShoppingCart() {
        return shoppingCart;
    }

    public void addGoodToCart(Good good) {
        shoppingCart.add(good);
    }

    @Override
    public String toString() {
        return shoppingCart.toString();
    }
}
