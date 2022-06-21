package by.it.smirnov.calc.entity;

import by.it.smirnov.calc.exception.CalcException;

public class Scalar extends Var {

private final double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar) {
            double add = this.value + ((Scalar) other).value;
            return new Scalar(add);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        }
        else return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar) {
            if(((Scalar) other).value == 0)
                throw new CalcException("division by zero %s / %s", this, (Scalar) other);
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }
        else return super.div(other);
    }
}
