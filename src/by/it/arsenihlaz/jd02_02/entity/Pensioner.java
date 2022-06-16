package by.it.arsenihlaz.jd02_02.entity;

public class Pensioner extends Customer {
    public final String name;

    public Pensioner(long number) {
        super(number);
        this.name = "Pensioner №" + number;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int numberOfGoods() {
        return super.numberOfGoods();
    }

    @Override
    public double speedFactor() {
        return 1.5;
    }
}
