package by.it.avramchuk.jd02_02.entity;

import by.it.avramchuk.jd02_02.services.CashierWorker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int plan;
    private final AtomicInteger countIN = new AtomicInteger(0);
    private final Deque<CashierWorker> openCashierCount;

    public Manager(int plan) {
        this.plan = plan;
        openCashierCount = new ArrayDeque<>();
    }

    public  void customerEnter (){
        countIN.getAndIncrement();
    }

    public boolean shopOpened(){
        return countIN.get()!=plan;
    }

    public void regulateCountCashier (int cashierNeeded, Shop shop){

        if (openCashierCount.size()<cashierNeeded){
            int index = openCashierCount.size();
            Cashier cashier = new Cashier(index+1);
            CashBox[] cashBoxes = CashBox.values();
            CashierWorker cashierWorker = new CashierWorker(cashier, cashBoxes[index], shop);
            openCashierCount.push(cashierWorker);
            cashierWorker.start();
            regulateCountCashier(cashierNeeded, shop);
        } else if (openCashierCount.size()>cashierNeeded && openCashierCount.size()!=1){
            openCashierCount.poll().setNeedToClose(true);
            regulateCountCashier(cashierNeeded, shop);
        }
    }
    public void closeAllCashier(){
        while (openCashierCount.size()>0){
            openCashierCount.poll().setNeedToClose(true);
        }
    }

}
