package by.it.ragach.jd02_02.entity;



public class Pensioner extends Customer{

    public final String name;

    public Pensioner(int number) {
        super(number);
        this.name = "Customer (Pensioner) №" + number;
    }

    @Override
    public double speedOfOperation() {
        return 1.5;
    }

    @Override
    public int numberOfGoods() {
        return super.numberOfGoods();
    }

    @Override
    public String toString() {
        return name;
    }
}
