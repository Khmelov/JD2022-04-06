package by.it.arsenihlaz.jd02_02.entity;

public class Cashier {
    public final String name;
    public double revenue;
    private boolean open;

    public Cashier(int number) {
        this.name = "Cashier №" + number;
    }

    public void setRevenue(double revenue) {
        this.revenue += revenue;
    }

    public double getRevenue() {
        return revenue;
    }

    @Override
    public String toString() {
        return "\t" + name;
    }

    public boolean open() {
        return open;
    }

    public void setOpened(boolean open) {
        this.open = open;
    }
}
