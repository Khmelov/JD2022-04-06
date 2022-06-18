package by.it.marchenko.jd02_03.interfaces;

import by.it.marchenko.jd02_03.models.Cashier;

import java.util.concurrent.atomic.AtomicInteger;

public interface CashierPullAction {
    AtomicInteger getCashierOnWorkCount();

    void setCashierOnWorkCount(int cashierOnWorkCount);

    int getSize();

    boolean add(Cashier cashier);

    Cashier notifyOnSleepCashier();

    void lullOnWorkCashier();
}
