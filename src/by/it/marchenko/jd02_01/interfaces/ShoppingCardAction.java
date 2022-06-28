package by.it.marchenko.jd02_01.interfaces;

import by.it.marchenko.jd02_01.models.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good good);
}
