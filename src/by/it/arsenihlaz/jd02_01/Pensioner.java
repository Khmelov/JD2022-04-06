package by.it.arsenihlaz.jd02_01;

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
}
