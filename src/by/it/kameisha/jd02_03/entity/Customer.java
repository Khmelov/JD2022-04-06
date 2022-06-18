package by.it.kameisha.jd02_03.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public static final int MIN_COUNT_GOODS = 2;
    public static final int MAX_COUNT_GOODS = 5;
    public static final int TIMEOUT_FACTOR = 1;
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
        return MIN_COUNT_GOODS;
    }

    public int getMaxCountGoods() {
        return MAX_COUNT_GOODS;
    }

    public double getTimeoutFactor() {
        return TIMEOUT_FACTOR;
    }

    public Object getMonitor() {
        return this;
    }
}
