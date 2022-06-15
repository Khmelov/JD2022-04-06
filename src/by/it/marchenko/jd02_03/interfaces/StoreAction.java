package by.it.marchenko.jd02_03.interfaces;

import by.it.marchenko.jd02_03.models.Store;
import by.it.marchenko.jd02_03.models.StoreQueue;
import by.it.marchenko.jd02_03.services.CashierPull;

public interface StoreAction {
    int getCurrentCustomerCount();

    int getCurrentCashierCount();

    CashierPull getCashierPull();

    Store getStore();

    void changeCustomerCurrentCount(int increment);

    void generateCashier(StoreQueue storeQueue);

}
