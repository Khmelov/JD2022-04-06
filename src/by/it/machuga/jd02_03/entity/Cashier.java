package by.it.machuga.jd02_03.entity;

public class Cashier {
    private final String name;
    private final int number;
    private double revenue;
    private boolean opened;
    private static volatile double totalRevenue;

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

    public static synchronized double getTotalRevenue() {
        return totalRevenue;
    }

    public static synchronized void setTotalRevenue(double totalRevenue) {
        Cashier.totalRevenue=totalRevenue;
    }

    @Override
    public String toString() {
        return name;
    }
}
