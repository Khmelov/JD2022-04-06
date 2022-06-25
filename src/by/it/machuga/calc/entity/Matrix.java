package by.it.machuga.calc.entity;

import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.operationExecutops.Divider;
import by.it.machuga.calc.operationExecutops.Multiplicator;
import by.it.machuga.calc.operationExecutops.Substractor;
import by.it.machuga.calc.operationExecutops.Summator;

import static by.it.machuga.calc.util.Converter.convertDoubleMultiDimensionArrayToString;
import static by.it.machuga.calc.util.Converter.convertStringToDoubleMultiDimensionArray;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value.clone();
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value.clone();
    }

    public Matrix(String strMatrix) {
        this.value = convertStringToDoubleMultiDimensionArray(strMatrix);
    }

    public double[][] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalculatorException {
        if (other instanceof Matrix matrix && this.value.length == matrix.value.length
                && this.value[0].length == matrix.value[0].length) {
            return Summator.addMatrixToMatrix(this, matrix);
        } else if (other instanceof Scalar scalar) {
            return Summator.addScalarToMatrix(this, scalar);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalculatorException {
        if (other instanceof Matrix matrix && this.value.length == matrix.value.length
                && this.value[0].length == matrix.value[0].length) {
            return Substractor.subMatrixFromMatrix(this, matrix);
        } else if (other instanceof Scalar scalar) {
            return Substractor.subScalarFromMatrix(this, scalar);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalculatorException {
        if (other instanceof Matrix matrix && this.value[0].length == matrix.value.length) {
            return Multiplicator.mulMatrixByMatrix(this, matrix);
        } else if (other instanceof Vector vector && this.value[0].length == vector.getValue().length) {
            return Multiplicator.mulMatrixByVector(this, vector);
        } else if (other instanceof Scalar scalar) {
            return Multiplicator.mulMatrixByScalar(this, scalar);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalculatorException {
        if (other instanceof Scalar scalar && scalar.getValue() != 0) {
            return Divider.divMatrixByScalar(this, scalar);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return convertDoubleMultiDimensionArrayToString(value);
    }
}
