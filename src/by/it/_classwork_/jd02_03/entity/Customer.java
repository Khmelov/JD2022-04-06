package by.it._classwork_.jd02_03.entity;

public class Customer {


    private final String name;
    private boolean waiting;

    public Customer(long number) {
        this.name = "Customer №" + number;
    }


    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Object getMonitor() {
        return this;
    }

    @Override
    public String toString() {
        return name;
    }
}
