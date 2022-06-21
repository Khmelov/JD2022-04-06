package by.it.kadulin.jd02_02.entity;

import by.it.kadulin.jd02_02.interfaces.BuyerAction;
import by.it.kadulin.jd02_02.repository.PriceListRepo;
import by.it.kadulin.jd02_02.util.RandomGenerator;
import by.it.kadulin.jd02_02.util.Timer;

public abstract class Buyer extends Thread implements BuyerAction {
    protected final String name;
    protected final long number;
    protected double mltSpeedOperation;
    protected int countWTB;
    protected boolean waiting;
    protected ShoppingCart shoppingCart;


    public Buyer(long number, String name) {
        this.name = name;
        this.number = number;
    }


    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public boolean isWaiting() {
        return waiting;
    }

    @Override
    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }



    @Override
    public int getCountWTB() {
        return countWTB;
    }

    @Override
    public double getMltSpeedOperation() {
        return mltSpeedOperation;
    }





    @Override
    public String toString() {
        return name + "# " + number;
    }
}
