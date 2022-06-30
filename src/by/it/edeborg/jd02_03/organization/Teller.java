package by.it.edeborg.jd02_03.organization;


public class Teller {
    private final String name;
    private int revenue;

    public int getRevenue() {
        return revenue;
    }

    public void addRevenue(int revenue) {
        this.revenue = this.revenue+revenue;
    }

    public Teller(int number) {
        this.name = "Teller№" + number;
    }

    @Override
    public String toString() {
        return "\t" + name;
    }
}
