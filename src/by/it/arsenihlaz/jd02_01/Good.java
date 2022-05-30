package by.it.arsenihlaz.jd02_01;

public class Good {

    private final String name;
    private final double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}
