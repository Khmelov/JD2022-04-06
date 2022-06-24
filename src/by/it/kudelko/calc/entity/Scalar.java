package by.it.kudelko.calc.entity;

import by.it.kudelko.calc.exception.CalcException;

public class Scalar extends Var {

    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
        return new Scalar(this.value + otherScalar.value);
        } else{
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
            return new Scalar(this.value - otherScalar.value);
        } else{
            return other.add(this).mul(new Scalar(-1));
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
            return new Scalar(this.value * otherScalar.value);
        } else{
            return other.add(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
            return new Scalar(this.value / otherScalar.value);
        } else{
            return super.div(other);
        }
    }

    public double getValue() {return this.value;}

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
