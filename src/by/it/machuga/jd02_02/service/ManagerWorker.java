package by.it.machuga.jd02_02.service;

import by.it.machuga.jd02_02.entity.Cashier;
import by.it.machuga.jd02_02.entity.Manager;
import by.it.machuga.jd02_02.entity.Store;

import java.util.Objects;

import static by.it.machuga.jd02_02.util.Constants.CASHIERS_NUMBER;

public class ManagerWorker extends Thread {
    private final Store store;

    public ManagerWorker(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        Manager manager = store.getManager();
        createCashiers(CASHIERS_NUMBER, manager);
        while (!manager.storeClosed()) {
            manageCashiers(manager);
        }
    }

    private void createCashiers(int cashiersNumber, Manager manager) {
        for (int j = 1; j <= cashiersNumber; j++) {
            Cashier cashier = new Cashier(j);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            manager.addClosedCashiers(cashierWorker);
        }
    }

    private void manageCashiers(Manager manager) {
        int queueSize = store.getQueue().getSize();
        int openedCashiersNumber = manager.getOpenedCashiersNumber();
        int countCashiers = calculateCashiers(queueSize);
        if (openedCashiersNumber > countCashiers) {
            closeCashiers(openedCashiersNumber - countCashiers, manager);
        } else if (openedCashiersNumber < countCashiers) {
            openCashiers(countCashiers - openedCashiersNumber, manager);
        }
    }

    private void openCashiers(int number, Manager manager) {
        for (int i = 0; i < number; i++) {
            CashierWorker cashierWorker = manager.extractClosedCashier();
            if (Objects.nonNull(cashierWorker)) {
                cashierWorker.getCashier().setOpened(true);
                if (cashierWorker.getState().equals(State.NEW))
                    cashierWorker.start();
                manager.addOpenedCashiers(cashierWorker);
            }
        }
    }

    private void closeCashiers(int number, Manager manager) {
        for (int i = 0; i < number; i++) {
            CashierWorker cashierWorker = manager.extractOpenedCashier();
            if (Objects.nonNull(cashierWorker)) {
                cashierWorker.getCashier().setOpened(false);
                while (!cashierWorker.getState().equals(State.TERMINATED)) ;
                cashierWorker = new CashierWorker(cashierWorker.getCashier(), store);
                manager.addClosedCashiers(cashierWorker);
                System.out.println();
            }
        }
    }

    private int calculateCashiers(int queueSize) {
        if (queueSize > 0 && queueSize <= 5) {
            return 1;
        } else if (queueSize > 5 && queueSize <= 10) {
            return 2;
        } else if (queueSize > 10 && queueSize <= 15) {
            return 3;
        } else if (queueSize > 15 && queueSize <= 20) {
            return 4;
        } else if (queueSize > 20) {
            return 5;
        } else {
            return 0;
        }
    }
}
