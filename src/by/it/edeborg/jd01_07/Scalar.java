package by.it.edeborg.jd01_07;

class Scalar extends Var
{

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String line) {
        this.value = Double.parseDouble(line);
    }

    public double setValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}