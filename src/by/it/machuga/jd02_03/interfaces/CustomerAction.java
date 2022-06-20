package by.it.machuga.jd02_03.interfaces;

import by.it.machuga.jd02_03.entity.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goToQueue();

    void goOut();
}