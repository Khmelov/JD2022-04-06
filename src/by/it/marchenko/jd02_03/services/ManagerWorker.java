package by.it.marchenko.jd02_03.services;

import by.it.marchenko.jd02_03.interfaces.ManagerAction;
import by.it.marchenko.jd02_03.models.Manager;

import java.util.concurrent.atomic.AtomicInteger;

public class ManagerWorker implements ManagerAction {
    private final Manager manager;
    private final int plan;
    private final AtomicInteger totalCustomerCount;
    private final AtomicInteger atomicNotServicedCustomerCount;


    public ManagerWorker(Manager manager) {
        this.manager = manager;
        this.plan = manager.getPlan();
        this.totalCustomerCount = new AtomicInteger(0);
        this.atomicNotServicedCustomerCount = new AtomicInteger(0);
    }

    @Override
    public Manager getManager() {
        return manager;
    }

    @Override
    public int getTotalCustomerCount() {
        return totalCustomerCount.intValue();
    }

    @Override
    public int getNotServicedCustomerCount() {
        return atomicNotServicedCustomerCount.intValue();
    }

    @Override
    public void increaseTotalCustomerCount() {
        totalCustomerCount.getAndIncrement();
    }

    @Override
    public void increaseNotServicedCustomerCount() {
        atomicNotServicedCustomerCount.getAndIncrement();
    }

    @Override
    public boolean storeOpened() {
        return totalCustomerCount.intValue() != plan;
    }
}