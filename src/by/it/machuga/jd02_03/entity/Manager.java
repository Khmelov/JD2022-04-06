package by.it.machuga.jd02_03.entity;

import by.it.machuga.jd02_03.service.CashierWorker;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private final int plan;
    private final AtomicInteger countIn = new AtomicInteger(0);
    private final AtomicInteger countOut = new AtomicInteger(0);
    private final BlockingDeque<CashierWorker> openedCashiers;
    private final BlockingDeque<CashierWorker> closedCashiers;

    public Manager(int plan) {
        this.plan = plan;
        openedCashiers = new LinkedBlockingDeque<>();
        closedCashiers = new LinkedBlockingDeque<>();
    }

    public void addOpenedCashiers(CashierWorker cashierWorker) {
        try {
            openedCashiers.put(cashierWorker);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public CashierWorker extractOpenedCashier() {
        return openedCashiers.poll();
    }

    public void addClosedCashiers(CashierWorker cashierWorker) {
        try {
            closedCashiers.put(cashierWorker);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public CashierWorker extractClosedCashier() {
        return closedCashiers.poll();
    }

    public boolean storeOpened() {
        return countIn.get() != plan;
    }

    public boolean storeClosed() {
        return countOut.get() == plan;
    }

    public int getCustomerQuantity() {
        return countIn.get() - countOut.get();
    }

    public void customerIn() {
        countIn.getAndIncrement();
    }

    public void customerOut() {
        countOut.getAndIncrement();
    }

    public int getOpenedCashiersNumber() {
        return openedCashiers.size();
    }
}
