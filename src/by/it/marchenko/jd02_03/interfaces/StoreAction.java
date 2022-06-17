package by.it.marchenko.jd02_03.interfaces;

import by.it.marchenko.jd02_03.models.Store;
import by.it.marchenko.jd02_03.models.StoreQueue;
import by.it.marchenko.jd02_03.services.CashierPull;

import java.util.concurrent.atomic.AtomicInteger;

public interface StoreAction {
    AtomicInteger getCurrentCustomerCount();

    AtomicInteger getCurrentCashierCount();

    CashierPull getCashierPull();

    Store getStore();

    void changeCustomerCurrentCount(int increment);

    void generateCashier(StoreQueue storeQueue);

}
