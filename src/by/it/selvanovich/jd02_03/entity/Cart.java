package by.it.selvanovich.jd02_03.entity;

import java.util.ArrayList;

public class Cart {

    private final String name;
    private final long cartNumber;
    private final ArrayList<Good> cart = new ArrayList<>();
    private int totalPrice;

    public Cart(long number) {
        this.cartNumber = number;
        this.name = "cart №" + cartNumber;
        this.totalPrice = 0;
    }

    public void addToCart(Good good) {
        cart.add(good);
        totalPrice += good.showPrice();
    }

    public int checkTotalGoods() {
        return cart.size();
    }

    public int checkTotalPrice() {
        return totalPrice;
    }

    public void showCart() {
        for (Good good : cart) {
            System.out.println("\tCart №" + cartNumber + ": " + good);
        }
        System.out.println("Cart №" + cartNumber + ": total: " + cart.size() + " goods, with price: " + totalPrice + "BYN");
    }

    @Override
    public String toString() {
        return name;
    }
}
