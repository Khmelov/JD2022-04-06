package by.it.ragach.jd02_01;

public class Pensioner extends Customer{

    public final String name;

    public Pensioner(int number) {
        super(number);
        this.name = "Customer №" + number + " is Pensioner";
    }

    @Override
    public String toString() {
        return name;
    }
}
