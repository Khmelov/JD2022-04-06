package by.it.arsenihlaz.jd02_02.interfaces;

import by.it.arsenihlaz.jd02_02.entity.Good;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину

    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}