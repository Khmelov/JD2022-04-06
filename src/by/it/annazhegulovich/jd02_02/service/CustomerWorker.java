package by.it.annazhegulovich.jd02_02.service;

import by.it.annazhegulovich.jd02_02.entity.Queue;
import by.it.annazhegulovich.jd02_02.interfaces.CustomerAction;
import by.it.annazhegulovich.jd02_02.util.RandomGenerator;
import by.it.annazhegulovich.jd02_02.util.Timer;
import by.it.annazhegulovich.jd02_02.entity.Customer;
import by.it.annazhegulovich.jd02_02.entity.Good;
import by.it.annazhegulovich.jd02_02.entity.Store;

public class CustomerWorker extends Thread implements CustomerAction {
    private final Customer customer;
    private final Store store;

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
        store.getManager().customerEnter();
    }

    @Override
    public void run() {
        enteredStore(); //вошел в магазин (мгновенно)
        chooseGood(); //выбрал товар (от 0,5 до 2 секунд)
        gotoQueue();
        goOut();//отправился на выход(мгновенно)
        store.getManager().customerOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer+" entered "+store);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer+" started choose goods ");
        int timeout = RandomGenerator.get(500,2000);
        Timer.sleep(timeout);
        Good good= new Good();
        System.out.println(customer + " choose "+good);
        System.out.println(customer+" finished choose goods ");
        return good;
    }

    @Override
    public void gotoQueue() {
        Queue deque = store.getQueue();
        synchronized (customer.getMonitor()) {
            System.out.println(customer+" go to Queue");
            deque.add(customer);
            customer.setWaiting(true);
            while (customer.isWaiting())
            try {
                customer.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }

        System.out.println(customer + " leaves Queue");
    }

    @Override
    public void goOut() {
        System.out.println(customer+" leaved "+store);

    }

}
