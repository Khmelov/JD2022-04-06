package by.it.marchenko.jd02_02.interfaces;

public interface ManagerAction {
    boolean storeOpened();

    boolean storeClosed();

    void increaseTotalCustomerCount();

    int getTotalCustomerCount();
}
