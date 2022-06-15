package by.it.marchenko.jd02_02.interfaces;

import by.it.marchenko.jd02_02.models.Cashier;

public interface CashierPullAction {
    int getCashierOnWorkCount();

    void setCashierOnWorkCount(int cashierOnWorkCount);

    int getSize();

    boolean add(Cashier cashier);

    Cashier notifyOnSleepCashier();

    void lullOnWorkCashier();
}
