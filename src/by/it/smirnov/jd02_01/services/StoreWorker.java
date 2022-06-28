package by.it.smirnov.jd02_01.services;

import by.it.smirnov.jd02_01.entities.Store;
import by.it.smirnov.jd02_01.entities.customer_types.Customer;
import by.it.smirnov.jd02_01.entities.customer_types.Pensioner;
import by.it.smirnov.jd02_01.entities.customer_types.Student;
import by.it.smirnov.jd02_01.utils.Randomizer;
import by.it.smirnov.jd02_01.utils.Sleeper;

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
        List<String> attendenceStats = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int inFlowBase = Randomizer.get(5, 15);
            for (int i = 0; i < inFlowPerSec(inFlowBase, time) &&
                    CustomerWorker.getInStoreCustomers() < entranceLimit(time); i++) {
                Customer customer = getCustomer(++counter);
                CustomerWorker customerWorker = new CustomerWorker(customer, store);
                customerWorker.start();
                listCW.add(customerWorker);
            }
            Sleeper.sleep(1000);
            //attendenceStats.add(time + " " + CustomerWorker.getInStoreCustomers());
        }
        for (CustomerWorker worker : listCW) {
            while (worker.isAlive()) Sleeper.sleep(100);
        }
        System.out.println(store + " closed");
        for (String el : attendenceStats) {
            System.out.println(el);
        }
    }

    public static Customer getCustomer(int counter){
        int type = Randomizer.get(1,4);
        if(type == 1) return new Pensioner(counter);
        else if(type == 2 || type == 4) return new Student(counter);
        return new Customer(counter);
    }

    private static int entranceLimit(int time) {
        if (time==0) return 15;
        else if (time%60 <= 30) return 10 + time%30;
        else return 40 - time%30;
    }

    private static int inFlowPerSec(int inFlowBase, int time) {
        if (time==0) return inFlowBase;
        else if (time%60 <= 30) return inFlowBase + time%30;
        else return inFlowBase + 30 - time%30;
    }
}
