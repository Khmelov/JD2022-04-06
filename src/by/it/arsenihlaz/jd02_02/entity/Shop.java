package by.it.arsenihlaz.jd02_02.entity;

import by.it.arsenihlaz.jd02_02.service.CashierWorker;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final String name;
    private final Queue queue;
    private final Manager manager;
    List<CashierWorker> cashierWorkerOpen = new ArrayList<>();

    public List<CashierWorker> getCashierWorkerOpen() {
        return cashierWorkerOpen;
    }

    public void setCashierWorkerOpen(List<CashierWorker> cashierWorkerOpen) {
        this.cashierWorkerOpen = cashierWorkerOpen;
    }

    public Shop(String name, Queue queue, Manager manager) {
        this.name = name;
        this.queue = queue;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public Queue getQueue() {
        return queue;
    }

    @Override
    public String toString() {
        return "Shop " + name;
    }

}
