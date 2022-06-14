package by.it.annazhegulovich.jd02_02.service;

import by.it.annazhegulovich.jd02_02.entity.*;

public class CashierWorker implements Runnable {
    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(cashier+"opened");
        Manager manager = store.getManager();
        Queue queue = store.getQueue();
        while (manager.storeOpened()){
            Customer extract = queue.extract();

        }
        System.out.println(cashier+"closed");
    }
}
