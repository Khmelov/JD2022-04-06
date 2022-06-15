package by.it.kadulin.jd02_02.entity;

public class Manager {
    private final long timeToWork = 120_000;
    private final long openedTime = System.currentTimeMillis();
    private volatile int countIn = 1;
    private volatile int countOut = 0;
    private volatile boolean isShopOpened;

    public Manager() {
        isShopOpened = true;
    }

    public long getCurrentTimeOfWork() {
        return (System.currentTimeMillis() - openedTime) / 1000;
    }

    public void setShopOpened(boolean shopOpened) {
        isShopOpened = shopOpened;
    }


    public boolean isShopOpened() {
        return (System.currentTimeMillis() - openedTime) < timeToWork;
    }

    public int getCountIn() {
        return countIn;
    }

    public int getCountOut() {
        return countOut;
    }

    public synchronized void buyerEnter() {
        countIn++;
    }

    public synchronized void buyerOut() {
        countOut++;
    }

}
