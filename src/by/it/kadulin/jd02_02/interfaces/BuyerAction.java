package by.it.kadulin.jd02_02.interfaces;

import by.it.kadulin.jd02_02.entity.ShoppingCart;

public interface BuyerAction {
    ShoppingCart getShoppingCart();

    void setShoppingCart(ShoppingCart shoppingCart);

    boolean isWaiting();

    void setWaiting(boolean waiting);

    int getCountWTB();

    double getMltSpeedOperation();




}
