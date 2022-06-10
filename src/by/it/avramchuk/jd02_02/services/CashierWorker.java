package by.it.avramchuk.jd02_02.services;

import by.it.avramchuk.jd02_02.entity.Cashier;
import by.it.avramchuk.jd02_02.entity.Shop;
import by.it.avramchuk.jd02_02.interfaces.CashierAction;

public class CashierWorker extends Thread implements CashierAction {

    private final Cashier cashier;
    private final Shop shop;

    public CashierWorker(Cashier cashier, Shop shop) {
        this.cashier = cashier;
        this.shop = shop;
    }

    @Override
    public void run() {

    }

    @Override
    public void openCash() {

    }

    @Override
    public void closeCash() {

    }

    @Override
    public void giveCheck() {

    }

    @Override
    public void serveCustomer() {

    }
}
