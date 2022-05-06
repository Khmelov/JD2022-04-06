package by.it.korennaya.jd01_07;

class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar);
    }
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
