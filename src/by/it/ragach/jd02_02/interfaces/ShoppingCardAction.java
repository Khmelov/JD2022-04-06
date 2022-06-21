package by.it.ragach.jd02_02.interfaces;

import by.it.ragach.jd02_02.entity.Good;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину
    int putToCart(Good good);
}
