package by.it.machuga.jd02_02.entity;

public class Cashier {
    private final String name;
    private final int number;
    private double revenue;
    private boolean opened;

    public Cashier(int number) {
        this.name = "Cashier №" + number;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    @Override
    public String toString() {
        return name;
    }
}
