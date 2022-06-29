package by.it.eivanova.jd02_02.interfaces;

import by.it.eivanova.jd02_02.entity.Good;

public interface CustomerAction {

    void enteredStore();
    Good chooseGood();
    void goOut();
    void goToQueue();
}
