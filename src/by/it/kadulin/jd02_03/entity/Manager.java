package by.it.kadulin.jd02_03.entity;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
    private final int plan = 101;

    //    private final long timeToWork = 120_000;
    private final long openedTime = System.currentTimeMillis();
    private AtomicInteger countIn = new AtomicInteger(1);
    private AtomicInteger countOut = new AtomicInteger(0);
    private AtomicBoolean isShopOpened = new AtomicBoolean();
    private Semaphore cartSemaphore = new Semaphore(50);
    private volatile double totalShopRevenue = 0;


    public double getTotalShopRevenue() {
        return totalShopRevenue;
    }

    public synchronized void setTotalShopRevenue(double totalShopRevenue) {
        this.totalShopRevenue = this.totalShopRevenue + totalShopRevenue;
    }

    public void takeOneCart() {
        try {
            cartSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void giveOneCart() {
        cartSemaphore.release();
    }

    public Manager() {
        isShopOpened.set(true);
    }

    public long getCurrentTimeOfWork() {
        return (System.currentTimeMillis() - openedTime) / 1000;
    }

    public void setShopOpened(boolean shopOpened) {
        isShopOpened.set(shopOpened);
    }
    public boolean isShopOpened() {
        return isShopOpened.get();
    }

//    public boolean isShopOpened() {
//        return (System.currentTimeMillis() - openedTime) < timeToWork;
//    }

    public int getCountIn() {
        return countIn.get();
    }

    public int getCountOut() {
        return countOut.get();
    }

    public void buyerEnter() {
        countIn.incrementAndGet();
    }

    public void buyerOut() {
        countOut.incrementAndGet();
    }

    public int getPlan() {
        return plan;
    }

}
