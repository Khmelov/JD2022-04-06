package by.it.smirnov.jd02_01.interfaces;

import by.it.smirnov.jd02_01.entities.Good;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину
    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}
