package by.it.edeborg.jd02_02.organization;


public class Teller {

    public final String name;

    public Teller(int number) {
        this.name = "Teller N" + number;
    }

    @Override
    public String toString() {
        return "\t" + name;
    }
}
