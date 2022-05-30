package by.it.machuga.jd02_01.entity;

public class Customer {

    private final String name;
    private ShoppingKart shoppingKart;

    public Customer(String name) {
        this.name = name;
    }

    public ShoppingKart getShoppingKart() {
        return shoppingKart;
    }

    public void setShoppingKart(ShoppingKart shoppingKart) {
        this.shoppingKart = shoppingKart;
    }

    @Override
    public String toString() {
        return "Customer "+ name;
    }
}
