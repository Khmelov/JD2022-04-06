package by.it.machuga.calc.entity;

import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.operationExecutops.Divider;
import by.it.machuga.calc.operationExecutops.Multiplicator;
import by.it.machuga.calc.operationExecutops.Substractor;
import by.it.machuga.calc.operationExecutops.Summator;

public class Scalar extends Var {
    private final double value;

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
        return value;
    }

    @Override
    public Var add(Var other) throws CalculatorException {
        if (other instanceof Scalar scalar) {
            return Summator.addScalarToScalar(this, scalar);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalculatorException {
        if (other instanceof Scalar scalar) {
            return Substractor.subScalarFromScalar(this, scalar);
        } else {
            return new Scalar(-1).mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) throws CalculatorException {
        if (other instanceof Scalar scalar) {
            return Multiplicator.mulScalarByScalar(this, scalar);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalculatorException {
        if (other instanceof Scalar scalar && scalar.value != 0) {
            return Divider.divScalarByScalar(this, scalar);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
