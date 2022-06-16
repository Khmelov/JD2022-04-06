package by.it.machuga.jd02_02.interfaces;

import by.it.machuga.jd02_02.entity.Good;

public interface ShoppingCartAction {
    void takeCart();

    int putToCart(Good good);
}