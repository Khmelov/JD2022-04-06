package by.it.marchenko.jd02_02.interfaces;

import by.it.marchenko.jd02_02.models.Customer;

public interface StoreQueueAction {
    boolean add(Customer customer);

    Customer remove();

    int getSize();

    int getExpectedCashierCount(boolean mode);

}
