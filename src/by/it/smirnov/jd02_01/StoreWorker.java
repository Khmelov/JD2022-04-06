package by.it.smirnov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class StoreWorker extends Thread {
    private final Store store;

    public StoreWorker(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return store.toString();
    }

    @Override
    public void run() {
        System.out.println(store + " opened");
        int counter = 0;
        List<CustomerWorker> listCW = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int custNumbPerSec = Randomizer.get(0, 2);
            for (int i = 0; i < custNumbPerSec; i++) {
                Customer customer = new Customer(++counter);
                CustomerWorker customerWorker = new CustomerWorker(customer, store);
                customerWorker.start();
                listCW.add(customerWorker);
                for (CustomerWorker worker : listCW) {
                    try {
                        worker.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Sleeper.sleep(1000);
        }
        System.out.println(store + " closed");
    }
}
