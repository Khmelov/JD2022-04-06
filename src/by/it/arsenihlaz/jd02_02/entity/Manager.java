package by.it.arsenihlaz.jd02_02.entity;

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


    public int cashierNeeded(int queueSize) {

        if (queueSize > 0 && queueSize <= 5) {
           return 1;
        } else if (queueSize > 5 && queueSize <= 10) {
            return 2;
        } else if (queueSize > 10 && queueSize <= 15) {
            return 3;
        } else if (queueSize > 15 && queueSize <= 20) {
            return 4;
        } else
            return 5;
    }
}

