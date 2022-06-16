package by.it.avramchuk.jd02_01;

public class Customer {

    public final String name;
    private final int speedFactor;
    public Customer(long number) {
        this.name = "Customer №"+number;
        this.speedFactor = 1;
    }

    public int getSpeedFactor(){
        return speedFactor;
    }

    public int mayToBuy(){
        return RandomGenerator.get(2,5);
    }

    @Override
    public String toString() {
        return name;
    }
}
