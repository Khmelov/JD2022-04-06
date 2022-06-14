package by.it.annazhegulovich.jd02_02.entity;

public class Manager {
    private final int plan;
    private volatile int countIn;
    private volatile int countOut;

    public Manager(int plan) {
        this.plan = plan;
    }
    public boolean storeOpened(){
        return countIn!= plan;
    }
    public boolean storeClosed(){
        return countOut== plan;
    }
    public synchronized void customerEnter(){
        countIn++;
    }

    public synchronized void customerOut(){
        countOut++;
    }
}
