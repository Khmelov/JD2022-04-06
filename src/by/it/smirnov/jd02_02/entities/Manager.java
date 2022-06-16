package by.it.smirnov.jd02_02.entities;

public class Manager {

    private final int plan;

    public int getCountIn() {
        return countIn;
    }

    public int getCountOut() {
        return countOut;
    }

    private volatile int countIn;
    private volatile int countOut;

    public Manager(int plan) {
        this.plan = plan;
    }

    public boolean storeOpened(){
        return countIn != plan;
    }

    public boolean storeClosed(){
        return countOut == plan;
    }

    public synchronized void customerIn(){
        countIn++;
    }

    public synchronized void customerOut(){
        countOut++;
    }

    public synchronized int getInStoreCustomers() {
        return countIn - countOut;
    }
}
