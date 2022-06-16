package by.it.marchenko.jd02_02.interfaces;

import by.it.marchenko.jd02_02.models.Good;

public interface ShoppingCardAction {
    void takeCart();

    int putToCart(Good good);
}
