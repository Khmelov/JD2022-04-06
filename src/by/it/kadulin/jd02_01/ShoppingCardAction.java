package by.it.kadulin.jd02_01;

public interface ShoppingCardAction {

        void takeCart(); //взял корзину
        int putToCart(Good good); //положил товар в корзину(возвращает число товаров)

}
