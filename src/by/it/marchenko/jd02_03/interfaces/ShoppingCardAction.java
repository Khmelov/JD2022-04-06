package by.it.marchenko.jd02_03.interfaces;

import by.it.marchenko.jd02_03.models.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good good);
}
