package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.interfaces.ManagerAction;
import by.it.marchenko.jd02_02.models.Manager;

public class ManagerWorker implements ManagerAction {
    private final Manager manager;
    private final int plan;

    private volatile int totalCustomerCount;
    private volatile int notServicedCustomerCount;

    public ManagerWorker(Manager manager) {
        this.manager = manager;
        this.plan = manager.getPlan();
    }

    @Override
    public Manager getManager() {
        return manager;
    }

    @Override
    public int getTotalCustomerCount() {
        return totalCustomerCount;
    }

    @Override
    public int getNotServicedCustomerCount() {
        return notServicedCustomerCount;
    }

    @Override
    public void increaseTotalCustomerCount() {
        synchronized (manager) {
            totalCustomerCount++;
        }
    }

    @Override
    public void increaseNotServicedCustomerCount() {
        synchronized (manager) {
            notServicedCustomerCount++;
        }
    }

    @Override
    public boolean storeOpened() {
        return totalCustomerCount != plan;
    }
}