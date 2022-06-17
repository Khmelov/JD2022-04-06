package by.it.machuga.jd02_01.interfaces;

import by.it.machuga.jd02_01.entity.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goOut();
}