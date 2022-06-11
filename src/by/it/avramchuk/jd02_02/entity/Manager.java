package by.it.avramchuk.jd02_02.entity;

import by.it.avramchuk.jd02_02.services.CashierWorker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Manager {

    private final Shop shop;
    private final Deque<CashierWorker> openCashierCount;

    public Manager(Shop shop) {
        this.shop = shop;
        openCashierCount = new ArrayDeque<>();
    }

    public void regulateCountCashier (int cashierNeeded){

        if (openCashierCount.size()<cashierNeeded){
            CashierWorker cashierWorker = new CashierWorker(new Cashier(openCashierCount.size()+1), shop);
            openCashierCount.push(cashierWorker);
            cashierWorker.start();
            regulateCountCashier(cashierNeeded);
        } else if (openCashierCount.size()>cashierNeeded && openCashierCount.size()!=1){
            openCashierCount.poll().needToClose=true;
            regulateCountCashier(cashierNeeded);
        }
    }
    public void closeAllCashier(){
        while (openCashierCount.size()>0){
            openCashierCount.poll().needToClose = true;
        }
    }

}
