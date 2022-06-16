package by.it.kameisha.jd02_03.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int plan;
    private final AtomicInteger countIn = new AtomicInteger(0);
    private final AtomicInteger countOut = new AtomicInteger(0);

    public Manager(int plan) {
        this.plan = plan;
    }

    public boolean shopOpened() {
        return countIn.get() != plan;
    }

    public boolean shopClosed() {
        return countOut.get() == plan;
    }

    public void customerEnter() {
        countIn.getAndIncrement();
    }

    public void customerOut() {
        countOut.getAndIncrement();
    }
}
