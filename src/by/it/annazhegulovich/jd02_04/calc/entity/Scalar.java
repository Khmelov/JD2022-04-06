package by.it.annazhegulovich.jd02_04.calc.entity;

import by.it.annazhegulovich.jd02_04.calc.exception.CalcException;

public class Scalar extends Var {
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

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar) {
            //Scalar otherScalar = (Scalar) other;
            // double result = this.value + otherScalar.value;
            return new Scalar(this.value + otherScalar.value);
        } else {
            return other.add(this);
        }
    }
    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar) {
            //Scalar otherScalar = (Scalar) other;
            //double result = this.value - otherScalar.value;
            return new Scalar(this.value - otherScalar.value);
        } else {
            return other.add(this).mul(new Scalar(-1));
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar) {
            //Scalar otherScalar = (Scalar) other;
            //double result = this.value * otherScalar.value;
            return new Scalar(this.value * otherScalar.value);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar) {
            if (otherScalar.value==0){
                throw new CalcException("division by zero %s / %s", this, otherScalar);
            }
            //Scalar otherScalar = (Scalar) other;
            //double result = this.value / otherScalar.value;
            return new Scalar(this.value / otherScalar.value);
        } else {
            return super.div(other);
        }
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}