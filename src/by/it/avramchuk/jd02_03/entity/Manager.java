package by.it.avramchuk.jd02_03.entity;

import by.it.avramchuk.jd02_03.services.CashierWorker;

import java.util.ArrayDeque;
import java.util.Deque;

public class Manager {

    private final int plan;
    private volatile int countIn;
    private volatile int countOut;
    private final Deque<CashierWorker> openCashierCount;

    public Manager(int plan) {
        this.plan=plan;
        openCashierCount = new ArrayDeque<>();
    }
    public  synchronized void customerEnter(){
        countIn++;
    }
    public synchronized void customerOut(){
        countOut++;
    }
    public boolean shopOpened(){
        return countIn!=plan;
    }
    public  boolean shopClosed(){
        return countOut == plan;
    }

    public void closeAllCashier(){
        while (openCashierCount.size()>0){
            openCashierCount.poll().setNeedToClose(true);
        }
    }

}
