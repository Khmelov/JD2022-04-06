package by.it.smirnov.jd02_01.entities.customer_types;

public class Pensioner extends Customer{

    public final String name;

    public Pensioner(int number) {
        super(number);
        this.name = "Customer №" + number + " (Pensioner)";
    }

    @Override
    public int getSpeed(int millis) {
        return millis/10*15;
    }

    @Override
    public String toString() {
        return name;
    }
}
