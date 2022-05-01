package by.it.kameisha.jd01_08;

public class Scalar extends Var {
    private double value;
    public Scalar(double value){
        this.value = value;
    }

    public Scalar(Scalar scalar){
        this.value = scalar.value;
    }

    public Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        return null;
    }

    @Override
    public Var sub(Var other) {
        return null;
    }

    @Override
    public Var mul(Var other) {
        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }
}
