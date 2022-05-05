package by.it.machuga.jd01_09;

import static by.it.machuga.jd01_09.Converter.convertDoubleMultiDimensionArrayToString;
import static by.it.machuga.jd01_09.Converter.convertStringToDoubleMultiDimensionArray;

class Matrix extends Var {
    private final double[][] value;

    Matrix(double[][] value) {
        this.value = value.clone();
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value.clone();
    }

    Matrix(String strMatrix) {
        this.value = convertStringToDoubleMultiDimensionArray(strMatrix);
    }

    public double[][] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Matrix matrix && this.value.length == matrix.value.length
                && this.value[0].length == matrix.value[0].length) {
            return Summator.addMatrixToMatrix(this, matrix);
        } else if (other instanceof Scalar scalar) {
            return Summator.addScalarToMatrix(this, scalar);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix matrix && this.value.length == matrix.value.length
                && this.value[0].length == matrix.value[0].length) {
            return Substractor.subMatrixFromMatrix(this, matrix);
        } else if (other instanceof Scalar scalar) {
            return Substractor.subScalarFromMatrix(this, scalar);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
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
    public Var div(Var other) {
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
