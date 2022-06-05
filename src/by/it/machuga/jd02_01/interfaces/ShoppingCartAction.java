package by.it.machuga.jd02_01.interfaces;

import by.it.machuga.jd02_01.entity.Good;

public interface ShoppingCartAction {
    void takeCart();

    int putToCart(Good good);
}