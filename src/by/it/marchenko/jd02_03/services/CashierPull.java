package by.it.marchenko.jd02_03.services;

import by.it.marchenko.jd02_03.interfaces.CashierPullAction;
import by.it.marchenko.jd02_03.models.Cashier;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

import static by.it.marchenko.jd02_03.constants.CashierConstant.*;


public class CashierPull implements CashierPullAction {

    private final ConcurrentLinkedDeque<Cashier> cashierPull;
    private final AtomicInteger atomicCashierOnWorkCount;

    public CashierPull() {
        this.cashierPull = new ConcurrentLinkedDeque<>();
        this.atomicCashierOnWorkCount = new AtomicInteger(0);
    }

    @Override
    public AtomicInteger getCashierOnWorkCount() {
        return atomicCashierOnWorkCount;
    }

    @Override
    public void setCashierOnWorkCount(int cashierOnWorkCount) {
        atomicCashierOnWorkCount.getAndSet(cashierOnWorkCount);
    }

    @Override
    public int getSize() {
        synchronized (cashierPull) {
            return cashierPull.size();
        }
    }

    @Override
    public boolean add(Cashier cashier) {
            return cashierPull.offerLast(cashier);
    }

    @Override
    public Cashier notifyOnSleepCashier() {
        Cashier cashier;
        while (true) {
            cashier = cashierPull.pollLast();
            assert cashier != null;
            if (!cashier.isOnWork()) {
                cashier.setStatus(ON_WORK);
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
                cashier.setStatus(ON_SLEEP);
                cashierPull.offerLast(cashier);
                break;
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        double currentReceipts, sumReceipts = 0;
        int currentCustomerCount, customerCount = 0;
        for (Cashier cashier : cashierPull) {
            currentReceipts = cashier.getReceipts();
            currentCustomerCount = cashier.getServicedCustomerCount();
            sumReceipts += currentReceipts;
            customerCount += currentCustomerCount;
            sb.append(String.format(CURRENT_CASHIER_RESULT_FORMAT,
                    cashier, currentReceipts, currentCustomerCount));
        }
        sb.append(String.format(TOTAL_CASHIERS_RESULT_FORMAT,
                sumReceipts, customerCount));
        return sb.toString();
    }
}

