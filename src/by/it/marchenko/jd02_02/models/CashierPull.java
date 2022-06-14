package by.it.marchenko.jd02_02.models;

import by.it.marchenko.jd02_02.Printer;
import by.it.marchenko.jd02_02.interfaces.CashierPullAction;

import java.util.*;


public class CashierPull implements CashierPullAction {
    //private final List<Cashier> cashierPull;
    private final Deque<Cashier> cashierPull;
    private volatile int cashierOnWorkCount;

    public CashierPull() {
        this.cashierPull = new ArrayDeque<>();
        //this.cashierPull = new LinkedList<>();
        cashierOnWorkCount = 0;
    }

    @Override
    public int getSize() {
        synchronized (cashierPull) {
            return cashierPull.size();
        }
    }

    @Override
    public Cashier notifyOnSleepCashier() {
        Cashier cashier;// = null;
        while (true) {
            cashier = cashierPull.pollLast();
            assert cashier != null;
            if (!cashier.isOnWork()) {
                cashier.setOnWork(true);
                cashierPull.offerFirst(cashier);
                break;
            }
        }
        return cashier;
    }

    @Override
    public void lullOnWorkCashier() {
        Cashier cashier;
        while (true) {
            cashier = cashierPull.pollFirst();
            assert cashier != null;
            if (cashier.isOnWork()) {
                cashier.setOnWork(false);
                cashierPull.offerLast(cashier);
                break;
            }
        }
    }

    @Override
    public boolean add(Cashier cashier) {
        synchronized (cashierPull) {
            //cashierPull.
            return cashierPull.offerLast(cashier);
        }
    }


    @Override
    public Cashier changeCashierStatus() {

        synchronized (this.getMonitor()) {
            Cashier cashier = cashierPull.pollLast();//pollFirst();
            if (cashier != null) {
                boolean cashierOnWork = cashier.isOnWork();
                cashier.setOnWork(!cashierOnWork);
                cashierPull.addLast(cashier);
                //if (cashierOnWork) {
                //    try {
                //        cashier.wait();
                //    } catch (InterruptedException e) {
                //        throw new StoreException("Incorrect cashier sleeping", e);
                //    }
                //} else {
                //    cashier.notify();
                //}

            }
            //return cashierPull.remove(cashierPull.size() - 1);
            //cashierPull.removeFirst()
            return cashier;
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

    public Object getMonitor() {
        return cashierPull.getFirst();
    }
}

