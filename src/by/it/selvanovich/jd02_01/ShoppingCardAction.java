package by.it.selvanovich.jd02_01;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину

    void putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}
