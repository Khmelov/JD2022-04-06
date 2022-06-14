package by.it.smirnov.jd02_02.services;

import by.it.smirnov.jd02_02.entities.Cashier;
import by.it.smirnov.jd02_02.entities.Manager;
import by.it.smirnov.jd02_02.entities.Store;
import by.it.smirnov.jd02_02.entities.customer_types.Customer;
import by.it.smirnov.jd02_02.entities.customer_types.Pensioner;
import by.it.smirnov.jd02_02.entities.customer_types.Student;
import by.it.smirnov.jd02_02.utils.Randomizer;
import by.it.smirnov.jd02_02.utils.Sleeper;

import java.util.ArrayList;
import java.util.List;

import static by.it.smirnov.jd02_02.repo.Wordings.CLOSE;
import static by.it.smirnov.jd02_02.repo.Wordings.OPEN;

public class StoreWorker extends Thread {
    private final Store store;
    private List<Thread> threads;
    private int cashierNumber;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return store.toString();
    }

    @Override
    public void run() {
        System.out.printf(OPEN, store);
        int counter = 0;
        threads = new ArrayList<>();
        Manager manager = store.getManager();

        for (int time = 0; manager.storeOpened(); time++) {
            openCashiers();
            int inFlowBase = Randomizer.get(5, 15);
            for (int i = 0; manager.storeOpened() && i < inFlowPerSec(inFlowBase, time) &&
                    CustomerWorker.getInStoreCustomers() < entranceLimit(time); i++) {
                Customer customer = getCustomer(++counter);
                CustomerWorker customerWorker = new CustomerWorker(customer, store);
                customerWorker.start();
                threads.add(customerWorker);
            }
            Sleeper.sleep(1000);
        }

        for (Thread thread : threads) {
            while (thread.isAlive()) Sleeper.sleep(100);
        }
        System.out.printf(CLOSE, store);
    }

    private void openCashiers() {
        for (int i = 1; (store.getStoreQueue().queue.size() * 1.0 / store.cashiersAtWork) > 5; i++) {
            cashierNumber++;
            Cashier cashier = new Cashier(cashierNumber);
            CashierWorker cashierWorker = new CashierWorker(cashier, store);
            Thread thread = new Thread(cashierWorker);
            threads.add(thread);
            store.cashiersAtWork++;
            thread.start();
        }
    }

    public static Customer getCustomer(int counter) {
        int type = Randomizer.get(1, 4);
        if (type == 1) return new Pensioner(counter);
        else if (type == 2 || type == 4) return new Student(counter);
        return new Customer(counter);
    }

    private static int entranceLimit(int time) {
        if (time == 0) return 15;
        else if (time % 60 <= 30) return 10 + time % 30;
        else return 40 - time % 30;
    }

    private static int inFlowPerSec(int inFlowBase, int time) {
        if (time == 0) return inFlowBase;
        else if (time % 60 <= 30) return inFlowBase + time % 30;
        else return inFlowBase + 30 - time % 30;
    }
}
