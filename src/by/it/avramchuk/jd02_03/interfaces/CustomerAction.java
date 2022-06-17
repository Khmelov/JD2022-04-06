package by.it.avramchuk.jd02_03.interfaces;

import by.it.avramchuk.jd02_03.entity.Good;

public interface CustomerAction {
    void enteredStore();
    Good chooseGood();
    void goOut();
    void goToQueue();
}
