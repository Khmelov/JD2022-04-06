package by.it.edeborg.jd02_03.organization;

public class Pensioner extends Customer {
    public static final double TIMEOUT_FACTOR_PENSIONER = 1.5;
    private final String name;

    public Pensioner(long number) {
        super(number);
        name = "Pensioner №" + number;
    }

    @Override
    public double getTimeoutFactor() {
        return TIMEOUT_FACTOR_PENSIONER;
    }

    public String toString() {
        return name;
    }
}

