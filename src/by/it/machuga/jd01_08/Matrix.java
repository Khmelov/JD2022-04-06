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

    public double[][] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length
                && this.value[0].length == ((Matrix) other).value[0].length) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] + scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix matrix && this.value.length == matrix.value.length
                && this.value[0].length == matrix.value[0].length) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] - matrix.value[i][j];
                }
            }
            return new Matrix(result);
        } else if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] - scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Matrix matrix && this.value[0].length == matrix.value.length) {
            double[][] resultMatrix = new double[this.value.length][matrix.value[0].length];
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    double sum = 0.0;
                    for (int k = 0; k < this.value[i].length; k++) {
                        sum += this.value[i][k] * matrix.value[k][j];
                    }
                    resultMatrix[i][j] = sum;
                }
            }
            return new Matrix(resultMatrix);
        } else if (other instanceof Vector vector && this.value[0].length == vector.getValue().length) {
            double[] resultMatrix = new double[this.value.length];
            for (int i = 0; i < resultMatrix.length; i++) {
                double sum = 0.0;
                for (int j = 0; j < this.value[i].length; j++) {
                    sum += this.value[i][j] * vector.getValue()[j];
                }
                resultMatrix[i] = sum;
            }
            return new Vector(resultMatrix);
        } else if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] * scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar && scalar.getValue() != 0) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] = this.value[i][j] / scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return convertDoubleMultiDimensionArrayToString(value);
    }
}
