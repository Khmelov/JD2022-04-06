package by.it.annazhegulovich.jd02_03.interfaces;


import by.it.annazhegulovich.jd02_03.entity.Good;

public interface CustomerAction {
    void enteredStore(); //вошел в магазин (мгновенно)
    Good chooseGood(); //выбрал товар (от 0,5 до 2 секунд)
    void gotoQueue(); //иди в очередь
    void goOut(); //отправился на выход(мгновенно)
}