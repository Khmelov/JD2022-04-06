package by.it.annazhegulovich.jd02_02.entity;

public class Manager {
    private final int plan;
    private int countIn;
    private int countOut;

    public Manager(int plan) {
        this.plan = plan;
    }
    public boolean storeOpened(){
        return countIn!= plan;
    }
    public boolean storeClosed(){
        return countOut== plan;
    }
}
