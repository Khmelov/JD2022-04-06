package by.it.smirnov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Customer customer;
    private final Store store;
    private List<Good> shoppingCart;


    public ShoppingCart(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        shoppingCart = new ArrayList<>();
    }

    public List<Good> getShoppingCart() {
        return shoppingCart;
    }
}
