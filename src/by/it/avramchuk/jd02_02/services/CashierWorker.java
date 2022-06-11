package by.it.avramchuk.jd02_02.services;

import by.it._classwork_.jd02_02.util.RandomGenerator;
import by.it._classwork_.jd02_02.util.Timer;
import by.it.avramchuk.jd02_02.entity.Cashier;
import by.it.avramchuk.jd02_02.entity.Customer;
import by.it.avramchuk.jd02_02.entity.Shop;
import by.it.avramchuk.jd02_02.entity.ShopQueue;
import by.it.avramchuk.jd02_02.interfaces.CashierAction;

import java.util.Objects;

public class CashierWorker extends Thread implements CashierAction {

    private final Cashier cashier;
    private final Shop shop;
    public volatile boolean needToClose;

    public CashierWorker(Cashier cashier, Shop shop) {
        this.cashier = cashier;
        this.shop = shop;
        this.needToClose = false;
    }
    public void setNeedToClose(boolean value){
        this.needToClose = value;
    }

    @Override
    public void run() {
        openCash();
        while (!needToClose){
            serveCustomer();
        }
        closeCash();
    }

    @Override
    public void openCash() {
        System.out.println(cashier+ " is open");
    }

    @Override
    public void closeCash() {
        System.out.println(cashier+ " closed");
    }

    @Override
    public void giveCheck() {

    }

    @Override
    public void serveCustomer() {
        ShopQueue queue = shop.getQueue();
        Customer customer = queue.extract();
        if (Objects.nonNull(customer)) {
            System.out.println(cashier + " started service " + customer);
            int timeOut = RandomGenerator.get(2000, 5000);
            Timer.sleep(timeOut);
            giveCheck();
            System.out.println(cashier + " finished service " + customer);
            synchronized (customer.getMonitor()) {
                customer.isWaiting = false;
                customer.notify();
            }
        }
    }
}
