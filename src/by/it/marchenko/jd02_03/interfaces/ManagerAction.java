package by.it.marchenko.jd02_03.interfaces;

import by.it.marchenko.jd02_03.models.Manager;

public interface ManagerAction {
    Manager getManager();

    int getTotalCustomerCount();

    int getNotServicedCustomerCount();

    void increaseTotalCustomerCount();

    void increaseNotServicedCustomerCount();

    boolean storeOpened();
}
