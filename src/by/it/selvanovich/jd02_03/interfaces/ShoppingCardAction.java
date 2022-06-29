package by.it.selvanovich.jd02_03.interfaces;

import by.it.selvanovich.jd02_03.entity.Good;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину

    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}
