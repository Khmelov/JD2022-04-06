package by.it.smirnov.jd02_02.interfaces;

import by.it.smirnov.jd02_02.entities.Good;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину
    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}
