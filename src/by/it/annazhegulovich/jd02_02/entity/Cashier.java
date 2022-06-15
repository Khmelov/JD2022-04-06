package by.it.annazhegulovich.jd02_02.entity;

public class Cashier {
    public final String name;


    public Cashier(int number) {
        this.name = "cashier №" + number;
    }

    @Override
    public String toString() {
        return "\t" + name ;
    }
}
