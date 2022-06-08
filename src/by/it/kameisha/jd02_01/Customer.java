package by.it.kameisha.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static long currentId = System.currentTimeMillis();
    private final String name;
    private final long id;
    private final List<Good> shoppingCart = new ArrayList<>();

    public Customer(long number) {
        id = ++currentId;
        name = "Customer №" + number;
    }

    public List<Good> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getMinCountGoods() {
        return 2;
    }

    public int getMaxCountGoods() {
        return 5;
    }

    public double getTimeoutFactor() {
        return 1;
    }

}
