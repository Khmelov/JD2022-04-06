package by.it.kameisha.calc.entity;

import by.it.kameisha.calc.ResMan;
import by.it.kameisha.calc.constants.Errors;
import by.it.kameisha.calc.exception.CalcException;

public class Scalar extends Var {
    private final double value;
    private final ResMan resMan = ResMan.INSTANCE;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double result = this.value + scalar.value;
            return new Scalar(result);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double result = this.value - scalar.value;
            return new Scalar(result);
        } else {
            return other.add(this).mul(new Scalar(-1));
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double result = this.value * scalar.value;
            return new Scalar(result);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            if (scalar.value == 0) {
                throw new CalcException(resMan.get(Errors.DIVISION_ZERO) +" %s / %s", value, scalar);
            }
            double result = this.value / scalar.value;
            return new Scalar(result);
        } else {
            return super.div(other);
        }
    }
}
