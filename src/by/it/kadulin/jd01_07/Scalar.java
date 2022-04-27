package by.it.kadulin.jd01_07;

class Scalar extends Var {

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar value) {
        this.value = value.value;
    }

    public Scalar(String value) {
        this.value = Double.parseDouble(value);
    }

    private final double value;


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
