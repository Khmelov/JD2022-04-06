package by.it._classwork_.jd01_07;

class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value=scalar.value;
    }

    public Scalar(String stringValue) {
        this.value=Double.parseDouble(stringValue);
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
