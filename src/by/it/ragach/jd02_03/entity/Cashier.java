package by.it.ragach.jd02_03.entity;

public class Cashier {
    public final String name;
    public double revenue;

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

}
