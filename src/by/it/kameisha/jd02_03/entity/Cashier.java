package by.it.kameisha.jd02_03.entity;

public class Cashier {
    private final String name;
    private int revenue;

    public int getRevenue() {
        return revenue;
    }

    public void addRevenue(int revenue) {
        this.revenue = this.revenue+revenue;
    }

    public Cashier(int number) {
        this.name = "Cashier№" + number;
    }

    @Override
    public String toString() {
        return "\t" + name;
    }
}
