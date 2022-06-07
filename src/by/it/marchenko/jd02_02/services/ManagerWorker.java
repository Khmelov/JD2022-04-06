package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.interfaces.ManagerAction;
import by.it.marchenko.jd02_02.models.Manager;

public class ManagerWorker implements ManagerAction {
    private final Manager manager;
    private final int plan;

    private volatile int totalCustomerCount;

    public ManagerWorker(Manager manager) {
        this.manager = manager;
        this.plan = manager.getPlan();
    }

    @Override
    public void increaseTotalCustomerCount() {
        synchronized (manager) {
            totalCustomerCount++;
        }
    }

    @Override
    public int getTotalCustomerCount() {
        return totalCustomerCount;
    }

    @Override
    public boolean storeOpened() {
        return totalCustomerCount != plan;
    }

    @Override
    public boolean storeClosed() {
        return totalCustomerCount == plan;
    }

    public Manager getManager() {
        return manager;
    }
}
