package by.it.marchenko.jd02_02.interfaces;

import by.it.marchenko.jd02_02.models.Cashier;

public interface CashierPullAction {
    boolean add(Cashier cashier);

    Cashier remove();

    int getSize();
}
