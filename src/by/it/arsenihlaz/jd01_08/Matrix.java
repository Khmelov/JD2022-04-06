package by.it.arsenihlaz.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {
    private final double[][] value;
    private double[] value2;

    public Matrix(double[][] value) {
        this.value = value.clone();
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value.clone();
    }

    public Matrix(String strMatrix) {
        String strMatrixNew = strMatrix.replaceAll("[{}]", "");
        String[] arrayStrMatrix = strMatrixNew.split(",");
        this.value2 = new double[arrayStrMatrix.length];
        for (int i = 0; i < arrayStrMatrix.length; i++) {
            this.value2[i] = Double.parseDouble(arrayStrMatrix[i]);
        }

        int columns = (int) Math.sqrt(value2.length);
        int lines = value2.length / columns;
        this.value = new double[columns][lines];
        int i = 0;
        for (int j = 0; j < columns; j++) {
            for (int k = 0; k < lines; k++) {
                value[j][k] = value2[i];
                i++;
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] + scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix othermatrix) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] + othermatrix.getValue()[i][j];
                }
            }
            return new Matrix(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] - scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix othermatrix) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] - othermatrix.getValue()[i][j];
                }
            }
            return new Matrix(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] * scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector vector) {
            double[] resultVector = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < vector.getValue().length; j++) {
                    resultVector[i] = resultVector[i] + this.value[i][j] * vector.getValue()[j];
                }
            }
            return new Vector(resultVector);
        } else if (other instanceof Matrix othermatrix) {
            double[][] resultmatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    for (int k = 0; k < othermatrix.getValue().length; k++) {
                        resultmatrix[i][j] = resultmatrix[i][j] + this.value[i][k] * othermatrix.getValue()[k][j];
                    }
                }
            }
            return new Matrix(resultmatrix);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        String stringArrays = Arrays.deepToString(value);
        stringArrays = stringArrays.replaceAll("[\\[]", "{");
        stringArrays = stringArrays.replaceAll("[\\]]", "}");
        return stringArrays;
    }

    public double[][] getValue() {
        return value;
    }
}

