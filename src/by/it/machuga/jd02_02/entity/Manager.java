package by.it.machuga.jd02_02.entity;

import by.it.machuga.jd02_02.service.CashierWorker;

import java.util.ArrayDeque;
import java.util.Deque;

public class Manager {
    private final int plan;
    private volatile int countIn;
    private volatile int countOut;
    private final Deque<CashierWorker> openedCashiers;
    private final Deque<CashierWorker> closedCashiers;

    public Manager(int plan) {
        this.plan = plan;
        openedCashiers = new ArrayDeque<>();
        closedCashiers = new ArrayDeque<>();
    }

    public void addOpenedCashiers(CashierWorker cashierWorker) {
        openedCashiers.add(cashierWorker);
    }

    public CashierWorker extractOpenedCashier() {
        return openedCashiers.poll();
    }

    public void addClosedCashiers(CashierWorker cashierWorker) {
        closedCashiers.add(cashierWorker);
    }

    public CashierWorker extractClosedCashier() {
        return closedCashiers.poll();
    }

    public boolean storeOpened() {
        return countIn != plan;
    }

    public boolean storeClosed() {
        return countOut == plan;
    }

    public int getCustomerQuantity() {
        return countIn - countOut;
    }

    public synchronized void customerIn() {
        countIn++;
    }

    public synchronized void customerOut() {
        countOut++;
    }

    public int getOpenedCashiersNumber() {
        return openedCashiers.size();
    }
}
