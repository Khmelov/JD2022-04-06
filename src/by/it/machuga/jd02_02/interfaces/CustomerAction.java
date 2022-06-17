package by.it.machuga.jd02_02.interfaces;

import by.it.machuga.jd02_02.entity.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goToQueue();

    void goOut();
}