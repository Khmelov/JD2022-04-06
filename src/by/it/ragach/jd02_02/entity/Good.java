package by.it.ragach.jd02_02.entity;


public class Good extends PriceListRepo {

    private final String name;
    private final double price;

    public Good(String name, double price) {
        this.name = name;
        this.price = PriceListRepo.getPrice(name);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return name +"("+"price " + price+")";
    }
}
