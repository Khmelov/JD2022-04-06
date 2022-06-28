package by.it.arsenihlaz.calculator.entity;

import by.it.arsenihlaz.calculator.constants.Message;
import by.it.arsenihlaz.calculator.exception.CalcException;
import by.it.arsenihlaz.calculator.util.ResourceManager;


public class Scalar extends Var {
    private final ResourceManager resourceManager = ResourceManager.INSTANSE;
    private double value;

    @Override
    public String toString() {
        return Double.toString(value);
    }

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
        if (other instanceof Scalar otherScalar) {
            double result = this.value + otherScalar.value;
            return new Scalar(result);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar) {
            double result = this.value - otherScalar.value;
            return new Scalar(result);
        } else {
            return other.sub(this).mul(new Scalar(-1));
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar) {
            double result = this.value * otherScalar.value;
            return new Scalar(result);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar) {
            if (otherScalar.value == 0) {
                throw new CalcException(resourceManager.getValue(Message.DIVISION_BY_ZERO) + " %s / %s", this, otherScalar);
            }
            double result = this.value / otherScalar.value;
            return new Scalar(result);
        } else {
            return super.div(other);
        }
    }

    public double getValue() {
        return value;
    }
}
