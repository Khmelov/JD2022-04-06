package by.it.avramchuk.jd02_03.entity;

import by.it.avramchuk.jd02_03.services.CashierWorker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int plan;
    private final AtomicInteger countIn = new AtomicInteger(0);
    private final Deque<CashierWorker> openCashierCount;

    public Manager(int plan) {
        this.plan=plan;
        openCashierCount = new ArrayDeque<>();
    }

    public void customerEnter(){
        countIn.getAndIncrement();
    }

    public boolean shopOpened(){
        return countIn.get()!=plan;
    }


    public void closeAllCashier(){
        while (openCashierCount.size()>0){
            openCashierCount.poll().setNeedToClose(true);
        }
    }
    public void regulateCountCashier (int cashierNeeded, Shop shop, ExecutorService pool){

        if (openCashierCount.size()<cashierNeeded){
            int index = openCashierCount.size();
            Cashier cashier = new Cashier(index+1);
            CashBox[] cashBoxes = CashBox.values();
            CashierWorker cashierWorker = new CashierWorker(cashier, cashBoxes[index], shop);
            openCashierCount.push(cashierWorker);
            pool.submit(cashierWorker);
            regulateCountCashier(cashierNeeded, shop, pool);
        } else if (openCashierCount.size()>cashierNeeded && openCashierCount.size()!=1){
            openCashierCount.poll().setNeedToClose(true);
            regulateCountCashier(cashierNeeded, shop, pool);
        }
    }
}
