package by.it.ragach.jd02_01.interfaces;

import by.it.ragach.jd02_01.entity.Good;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину
    int putToCart(Good good);
}
