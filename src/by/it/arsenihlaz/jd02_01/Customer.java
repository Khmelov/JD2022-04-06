package by.it.arsenihlaz.jd02_01;


public class Customer {

    public final String name;

    public Customer(long number) {
        this.name = "Customer №" + number;
    }

    @Override
    public String toString() {
        return name;
    }

    public int numberOfGoods(){
        return RandomGenerator.get(2, 5);
    }

    public double speedFactor(){
        return 1.0;
    }
}
