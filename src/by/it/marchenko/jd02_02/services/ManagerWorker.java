package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.interfaces.ManagerAction;
import by.it.marchenko.jd02_02.models.Manager;

public class ManagerWorker implements ManagerAction {
    private final StoreWorker storeWorker;
    private final int plan;
    private volatile int totalCustomerCount;


    public ManagerWorker(StoreWorker storeWorker, Manager manager) {
        this.storeWorker = storeWorker;
        this.plan = manager.getPlan();

    }

    @Override
    public void increaseTotalCustomerCount() {
        synchronized (storeWorker) {
            totalCustomerCount++;
        }
    }

    @Override
    public int getTotalCustomerCount() {
        return totalCustomerCount;
    }

    @Override
    public boolean storeOpened() {
        //int totalCustomerCount = storeWorker.getTotalCustomerCount();
        return totalCustomerCount != plan;
    }

    @Override
    public boolean storeClosed() {
        //int totalCustomerCount = storeWorker.getTotalCustomerCount();
        return totalCustomerCount == plan;
    }
}
