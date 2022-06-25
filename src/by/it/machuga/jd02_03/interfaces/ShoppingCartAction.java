package by.it.machuga.jd02_03.interfaces;

import by.it.machuga.jd02_03.entity.Good;

public interface ShoppingCartAction {
    void takeCart();

    int putToCart(Good good);
}