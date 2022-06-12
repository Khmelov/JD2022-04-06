package by.it.smirnov.jd02_02.services;

import by.it.smirnov.jd02_02.entities.Cashier;
import by.it.smirnov.jd02_02.entities.Manager;
import by.it.smirnov.jd02_02.entities.Store;
import by.it.smirnov.jd02_02.entities.StoreQueue;
import by.it.smirnov.jd02_02.entities.customer_types.Customer;
import by.it.smirnov.jd02_02.utils.Randomizer;
import by.it.smirnov.jd02_02.utils.Sleeper;

import java.util.Objects;
import java.util.Queue;

public class CashierWorker implements Runnable{

    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Cashier cashier, Store store) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(cashier + " opened");
        Manager manager = store.getManager();
        StoreQueue storeQueue = store.getStoreQueue();
        while (!manager.storeClosed()){
            Customer customer = storeQueue.extract();
            if(Objects.nonNull(customer)) {
                System.out.println(cashier + " starts serving " + customer);
                int timeout = Randomizer.get(2000, 5000);
                Sleeper.sleep(timeout);
                System.out.println(cashier + " finished serving " + customer);
                synchronized (customer.getMonitor()){
                    customer.setWaiting(false);
                    customer.notify();
                }
            }
            else {
                //Thread.onSpinWait();
                try {
                    //noinspection BusyWait
                    Thread.sleep(10); //bad
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(cashier + " closed");
    }
}
