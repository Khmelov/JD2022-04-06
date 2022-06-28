package by.it.smirnov.jd02_01.interfaces;

import by.it.smirnov.jd02_01.entities.Good;

public interface CustomerAction {
    void enteredStore(); //вошел в магазин (мгновенно)
    Good chooseGood(); //выбрал товар (от 0,5 до 2 секунд)
    void goOut(); //отправился на выход(мгновенно)

}
