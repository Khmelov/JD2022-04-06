package by.it.annazhegulovich.jd02_02.entity;

public class Customer {
private  static long currentId = System.currentTimeMillis();

    private final String name;
    private final long id;
    private boolean waiting;


    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Customer(long number) {
        id= currentId++;
        this.name = "Customer №" +number;

    }

    public Object getMonitor(){
        return this;
    }

    @Override
    public String toString() {
        return name;
    }

}
