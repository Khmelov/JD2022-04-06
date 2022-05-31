package by.it.kadulin.jd02_01;

public class Good {
    private final String name;
    private final double price;


    public Good(String name, double price) {
        this.price = PriceListRepo.getPrice(name);
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name " + name + " price: " + price;
    }

    public Good() {
        name = "unknown good";
        price = 0;
    }
}
