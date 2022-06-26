package by.it.ragach.jd02_03.interfaces;

import by.it.ragach.jd02_03.entity.Good;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину
    int putToCart(Good good);
}
