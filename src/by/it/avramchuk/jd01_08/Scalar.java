package by.it.avramchuk.jd01_08;

class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String stringValue) {
        this.value = Double.parseDouble(stringValue);
    }

    public double getValue() {
        return value;
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
