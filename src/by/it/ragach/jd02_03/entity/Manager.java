package by.it.ragach.jd02_03.entity;

//считает кол-во вошедших/вышедших, план

public class Manager {
    private final int plan;
    private volatile int countIn;
    private volatile int countOut;

    public Manager(int plan) {
        this.plan = plan;
    }

    public boolean shopOpened() {
        return countIn != plan;
    }

    public boolean shopClosed() {
        return countOut == plan;
    }

    public synchronized void customerEnter() {
        countIn++;
    }

    public synchronized void customerOut() {
        countOut++;
    }



}
