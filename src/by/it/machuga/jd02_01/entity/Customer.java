package by.it.machuga.jd02_01.entity;

import by.it.machuga.jd02_01.util.Constants;

public class Customer {

    private final String name;
    private ShoppingCart shoppingCart;
    private final int maxGood = 5;
    private final int minGood = 2;
    private final double selectionSpeed = 1.0;

    public Customer(String name) {
        this.name = name;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return name;
    }

    public int getMaxGood() {
        return maxGood;
    }

    public int getMinGood() {
        return minGood;
    }

    public double getSelectionSpeed() {
        return selectionSpeed;
    }

    @Override
    public String toString() {
        return Constants.CUSTOMER + name;
    }
}
