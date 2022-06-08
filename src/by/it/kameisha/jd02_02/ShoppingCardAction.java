package by.it.kameisha.jd02_02;

public interface ShoppingCardAction {

    void takeCart();    //взял корзину

    int putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}
