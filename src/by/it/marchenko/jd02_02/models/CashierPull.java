package by.it.marchenko.jd02_02.models;

import by.it.marchenko.jd02_02.Printer;
import by.it.marchenko.jd02_02.interfaces.CashierPullAction;

import java.util.ArrayList;
import java.util.List;

public class CashierPull implements CashierPullAction {
    private final List<Cashier> cashierPull;
    private volatile int cashierOnWorkCount;

    public CashierPull() {
        this.cashierPull = new ArrayList<>();
        cashierOnWorkCount = 0;
    }

    @Override
    public int getSize() {
        synchronized (cashierPull) {
            return cashierPull.size();
        }
    }

    @Override
    public boolean add(Cashier cashier) {
        synchronized (cashierPull) {
            return cashierPull.add(cashier);
        }
    }

    @Override
    public Cashier remove() {
        synchronized (cashierPull) {
            return cashierPull.remove(cashierPull.size() - 1);
        }
    }

    public int getCashierOnWorkCount() {
        synchronized (cashierPull) {
            return cashierOnWorkCount;
        }
    }

    public void setCashierOnWorkCount(int cashierOnWorkCount) {
        synchronized (cashierPull) {
            this.cashierOnWorkCount = cashierOnWorkCount;
        }
    }

    public boolean setOnWorkStatus(int count, boolean status) {
        synchronized (cashierPull) {
            int currentCount = 0;
            for (Cashier cashier : cashierPull) {
                if (currentCount == count) {
                    break;
                }
                if (!cashier.isOnWork()) {
                    cashier.setOnWork(status);
                    currentCount++;
                }
            }
            //for (int i = 0; i < cashierPull.size() - 1 || currentCount > count; i++) {
            //    if (!cashierPull.get(i).isOnWork()) {
            //        cashierPull.get(i).setOnWork(status);
            //        currentCount++;
            //    }
            //}
            return currentCount == count;
        }
    }

    public void printCashiers(Printer out) {
        double currentReceipts, sumReceipts = 0;
        int currentCustomerCount, customerCount = 0;
        for (Cashier cashier : cashierPull) {
            currentReceipts = cashier.getReceipts();
            sumReceipts += currentReceipts;
            currentCustomerCount = cashier.getServicedCustomerCount();
            customerCount += currentCustomerCount;
            out.printf("%s total receipts: %10.2f $, serviced customer count: %4d %n",
                    cashier, currentReceipts, currentCustomerCount);
            //cashier.getNotServicedCustomerCount()
        }
        out.printf("Total receipts: %27.2f $, total serviced customers: %3d%n", sumReceipts, customerCount);
        //out.println("Not serviced customer: ");
    }
}

