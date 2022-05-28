package by.it.marchenko.jd02_01.interfaces;

import by.it.marchenko.jd02_01.models.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goOut();
}
