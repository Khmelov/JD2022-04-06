package by.it.eivanova.jd02_02.entity;

import by.it.eivanova.jd02_02.util.RandomGenerator;

public class Customer {

    public final String name;
    private ShoppingCart myCart;
    private final int speedFactor;
    public boolean isWaiting;
    public Customer(long number) {
        this.name = "Customer №"+number;
        this.speedFactor = 1;
    }
    public void setMyCart(ShoppingCart myCart){
        this.myCart = myCart;
    }

    public ShoppingCart getMyCart(){
        return myCart;
    }

    public int getSpeedFactor(){
        return speedFactor;
    }

    public int mayToBuy(){
        return RandomGenerator.get(2,5);
    }

    public Customer getMonitor(){
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
