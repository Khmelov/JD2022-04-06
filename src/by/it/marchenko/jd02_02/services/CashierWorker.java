package by.it.marchenko.jd02_02.services;

import by.it.marchenko.jd02_02.Printer;
import by.it.marchenko.jd02_02.models.*;
import by.it.marchenko.jd02_02.utility.Delayer;
import by.it.marchenko.jd02_02.utility.RandomGenerator;

import java.util.Objects;

public class CashierWorker extends Thread {
    public static final int MIN_CASHIER_OPERATION_TIME = 2000;
    public static final int MAX_CASHIER_OPERATION_TIME = 5000;
    public static final String START_OPERATION = " start operation with ";
    public static final String FINISH_OPERATION = " finish operation with ";
    private final Cashier cashier;
    private final Store store;
    private final Delayer delayer;
    private final Printer out;

    private StoreQueue storeQueue;
    private ManagerWorker managerWorker;

    public CashierWorker(Cashier cashier, Store store, Delayer delayer, Printer out) {
        this.cashier = cashier;
        this.store = store;
        this.delayer = delayer;
        this.out = out;
    }

    @Override
    public void run() {
        initCashierWorker();
        out.println("\t\t\t" + cashier + " start operation in the " + store);

        while (managerWorker.storeOpened()) {
            Customer customer = storeQueue.remove();
            if (Objects.nonNull(customer)) {
                out.println("\t\t\t" + cashier + START_OPERATION + customer);
                int cashierOperationTime =
                        RandomGenerator.getRandom(MIN_CASHIER_OPERATION_TIME, MAX_CASHIER_OPERATION_TIME);
                delayer.performDelay(cashierOperationTime);
                out.println("\t\t\t" + cashier + FINISH_OPERATION + customer);
                synchronized (customer.getMonitor()) {
                    customer.setWaitingEnabled(false);
                    //out.println("\t\t\t\t" + customer + "processing with " + cashier);
                    customer.notify();
                }
            } else {
                //store.
                // TODO print cashier result and decrease amount of current cashier
                break;
                //Thread.onSpinWait();
            }
        }
    }

    private void initCashierWorker() {
        storeQueue = store.getStoreQueue();
        managerWorker = store.getManagerWorker();
    }
}
