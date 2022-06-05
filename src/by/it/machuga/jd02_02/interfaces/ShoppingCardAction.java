package by.it.machuga.jd02_02.interfaces;

import by.it.machuga.jd02_02.entity.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good good);
}