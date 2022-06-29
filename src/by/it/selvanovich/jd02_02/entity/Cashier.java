package by.it.selvanovich.jd02_02.entity;

public class Cashier {

    public final String name;
    public final int gain;

    public Cashier(int number) {
        this.name = "Cashier №" + number;
        gain = 0;
    }

    @Override
    public String toString() {
        return "\t" + name;
    }
}
