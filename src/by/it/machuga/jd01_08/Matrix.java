package by.it.machuga.jd01_08;

import static by.it.machuga.jd01_08.Converter.*;

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

    @Override
    public String toString() {
        return convertDoubleMultiDimensionArrayToString(value);
    }
}
