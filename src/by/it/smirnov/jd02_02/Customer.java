package by.it.smirnov.jd02_02;

public class Customer {

    public final String name;
    public Customer(int number) {
        this.name = "Customer №" + number;
    }

    @Override
    public String toString() {
        return name;
    }

    public int quantityNeed() {
        return Randomizer.get(2,5);
    }

    public int getSpeed(int millis) {
        return millis;
    }
}
