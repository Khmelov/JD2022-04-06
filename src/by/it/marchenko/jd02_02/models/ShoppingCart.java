package by.it.marchenko.jd02_02.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Good> shoppingCartList;

    public ShoppingCart(int capacity) {
        shoppingCartList = new ArrayList<>(capacity);
    }

    public int getSize() {
        return shoppingCartList.size();
    }

    public List<Good> getShoppingCartList() {
        return new ArrayList<>(shoppingCartList);
    }

    public void addGoodToCart(Good good) {
        shoppingCartList.add(good);
    }

    @Override
    public String toString() {
        return shoppingCartList.toString();
    }
}
