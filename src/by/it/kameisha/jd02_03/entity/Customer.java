package by.it.kameisha.jd02_03.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static long currentId = System.currentTimeMillis();
    private final String name;
    private boolean waiting;
    private final long id;

    public boolean isWaiting() {
        return waiting;
    }

    private final List<Good> shoppingCart = new ArrayList<>();

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

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

    public Object getMonitor() {
        return this;
    }
}
