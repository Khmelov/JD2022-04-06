package by.it.edeborg.jd02_03.interfaces;

import by.it.edeborg.jd02_03.organization.SomethingGood;

public interface ShoppingCardAction {

    void takeCart();    //взял корзину

    int putToCart(SomethingGood good); //положил товар в корзину(возвращает число товаров)
}

