package by.it.eivanova.jd02_01;

public interface ShoppingCardAction {
    void takeCart(); //взял корзину

    void putToCart(Good good); //положил товар в корзину(возвращает число товаров)
}
