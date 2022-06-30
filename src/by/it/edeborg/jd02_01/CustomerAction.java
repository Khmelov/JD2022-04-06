package by.it.edeborg.jd02_01;

public interface CustomerAction {
    void enteredStore(); //вошел в магазин (мгновенно)

    SomethingGood chooseGood(); //выбрал товар (от 0,5 до 3 секунд)

    void goOut(); //отправился на выход(мгновенно)

}