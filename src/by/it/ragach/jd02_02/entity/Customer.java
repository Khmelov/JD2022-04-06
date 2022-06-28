package by.it.ragach.jd02_02.entity;


import by.it.ragach.jd02_02.util.RandomGenerator;

public class Customer {

    public final String name;
    private boolean waiting;
    public ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Customer(long number) {
        this.name = "Customer №" + number;
    }

    public Object getMonitor(){
        return this;
    }

    @Override
    public String toString() {
        return name;
    }


    public int numberOfGoods(){
        return RandomGenerator.get(2,5);
    }

    public double speedOfOperation(){
        return 1.0;
    }


}
