package by.it.selvanovich.jd02_03.entity;

public class Customer {

    private final String name;
    private final long customerNumber;
    private boolean waiting;
    private Cart cart;

    public Customer(long number) {
        customerNumber = number;
        this.name = "Customer №" + customerNumber;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Object getMonitor() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }

    public void takeCart() {
        cart = new Cart(customerNumber);
    }

    public void putToCart(Good good) {
        cart.addToCart(good);
    }

    public void showCart() {
        cart.showCart();
    }

    public int checkTotalGoods() {
        return cart.checkTotalGoods();
    }

    public int checkTotalPrice() {
        return cart.checkTotalPrice();
    }
}
