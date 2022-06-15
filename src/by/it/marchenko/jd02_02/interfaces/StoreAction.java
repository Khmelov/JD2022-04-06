package by.it.marchenko.jd02_02.interfaces;

import by.it.marchenko.jd02_02.models.Store;
import by.it.marchenko.jd02_02.models.StoreQueue;
import by.it.marchenko.jd02_02.services.CashierPull;

public interface StoreAction {
    int getCurrentCustomerCount();

    int getCurrentCashierCount();

    CashierPull getCashierPull();

    Store getStore();

    void changeCustomerCurrentCount(int increment);

    void generateCashier(StoreQueue storeQueue);

}
