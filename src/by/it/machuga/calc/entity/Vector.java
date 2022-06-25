package by.it.machuga.calc.entity;

import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.operationExecutops.Divider;
import by.it.machuga.calc.operationExecutops.Multiplicator;
import by.it.machuga.calc.operationExecutops.Substractor;
import by.it.machuga.calc.operationExecutops.Summator;

import static by.it.machuga.calc.util.Converter.convertDoubleArrayToString;
import static by.it.machuga.calc.util.Converter.convertStringToDoubleArray;

public class Vector extends Var {
    private final double[] value;

    public Vector(double[] value) {
        this.value = value.clone();
    }

    public Vector(Vector vector) {
        this.value = vector.value.clone();
    }

    public Vector(String strVector) {
        this.value = convertStringToDoubleArray(strVector);
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalculatorException {
        if (other instanceof Vector vector && this.value.length == vector.value.length) {
            return Summator.addVectorToVector(this, vector);
        } else if (other instanceof Scalar scalar) {
            return Summator.addScalarToVector(this, scalar);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalculatorException {
        if (other instanceof Vector vector && this.value.length == vector.value.length) {
            return Substractor.subVectorFromVector(this, vector);
        } else if (other instanceof Scalar scalar) {
            return Substractor.subScalarFromVector(this, scalar);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalculatorException {
        if (other instanceof Vector vector && this.value.length == vector.value.length) {
            return Multiplicator.mulVectorByVector(this, vector);
        } else if (other instanceof Scalar scalar) {
            return Multiplicator.mulVectorByScalar(this, scalar);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalculatorException {
        if (other instanceof Scalar scalar && scalar.getValue() != 0) {
            return Divider.divVectorByScalar(this, scalar);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return convertDoubleArrayToString(value);
    }
}
