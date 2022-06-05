package by.it.machuga.jd02_02.entity;

public class Cashier {
    private final String name;
    private double revenue;

    public Cashier(int number) {
        this.name = "Cashier №" + number;
    }

    public String getName() {
        return name;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }



    @Override
    public String toString() {
        return name;
    }
}
