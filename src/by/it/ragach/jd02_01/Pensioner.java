package by.it.ragach.jd02_01;

public class Pensioner extends Customer{

    public final String name;

    public Pensioner(int number) {
        super(number);
        this.name = "Customer (Pensioner) №" + number;
    }

    @Override
    public int speedOfOperation(int millis) {
        return millis/10*15;
    }

    @Override
    public String toString() {
        return name;
    }
}
