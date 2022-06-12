package by.it.kameisha.jd02_02.entity;

public class Manager {

    private final int plan;
    private int countIn;
    private int countOut;

    public Manager(int plan) {
        this.plan = plan;
    }

    public boolean shopOpened() {
        return countIn != plan;
    }

    public boolean shopClosed() {
        return countOut == plan;
    }
}
