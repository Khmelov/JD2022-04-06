package by.it.marchenko.jd02_02.interfaces;

import by.it.marchenko.jd02_02.models.Good;

public interface CustomerAction {
    void enteredStore();

    Good chooseGood();

    void goOut();
}
