package by.it.marchenko.jd02_03.interfaces;

import by.it.marchenko.jd02_03.models.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goOut();
}
