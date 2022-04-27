package by.it.marchenko.jd01_07;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar value) {
        this.value = value.value;
    }

    public Scalar(String stringScalar) {
        this.value = Double.parseDouble(stringScalar);
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
