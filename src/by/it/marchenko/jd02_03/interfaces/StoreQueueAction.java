package by.it.marchenko.jd02_03.interfaces;

import by.it.marchenko.jd02_03.models.Customer;

public interface StoreQueueAction {
    int getSize();

    boolean add(Customer customer);

    Customer remove();

    int calcExpectedCashierCount(boolean mode);

}
