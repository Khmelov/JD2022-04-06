package by.it.ragach.jd02_01;

public class Good extends PriceListRepo {

    final private String name;
    final private double price;

    public Good(String name, double price) {

        this.name = name;
        this.price = PriceListRepo.getPrice(name);
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
       return price;
    }

    @Override
    public String toString() {
        return name +"("+"price " + price+")";
    }
}
