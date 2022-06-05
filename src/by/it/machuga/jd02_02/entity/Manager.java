package by.it.machuga.jd02_02.entity;

public class Manager {
    private final int plan;
    private volatile int countIn;
    private volatile int countOut;

    public Manager(int plan) {
        this.plan = plan;
    }

    public boolean storeOpened() {
        return countIn != plan;
    }

    public boolean storeClosed() {
        return countOut == plan;
    }

    public int getCustomerQuantity() {
        return countIn - countOut;
    }

    public synchronized void customerIn() {
        countIn++;
    }

    public synchronized void customerOut() {
        countOut++;
    }

    public int getCountIn() {
        return countIn;
    }

    public int getCountOut() {
        return countOut;
    }
}
