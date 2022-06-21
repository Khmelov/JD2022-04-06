package by.it.selvanovich.jd02_02.entity;

import java.util.ArrayList;

public class Customer {


    private final String name;
    private boolean waiting;
    private final ArrayList<Good> cart = new ArrayList<>();
    private int total;

    public Customer(long number) {
        this.name = "Customer №" + number;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Object getMonitor(){
        return this;
    }

    @Override
    public String toString() {
        return name;
    }

    public void putToCart(Good good) {
        cart.add(good);
    }

    public void showCart() {
        for (Good good : cart) {
            System.out.println(good);
            total += good.showPrice();
        }
        System.out.println("total: " + cart.size() + " goods, with price: " + total + "BYN");
    }
}
