package by.it.selvanovich.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {


    double[][] values;

    public Matrix(double[][] value) {
        double[][] matrix = new double[value.length][];
        for (int i = 0; i < value.length; i++) {
            matrix[i] = value[i].clone();
        }
        this.values = matrix;
    }

    public Matrix(Matrix matrix) {
        double[][] newMatrix = new double[matrix.values.length][];
        for (int i = 0; i < matrix.values.length; i++) {
            newMatrix[i] = matrix.values[i].clone();
        }
        this.values = newMatrix;
    }

    public Matrix(String str) {
        String[] strRow = str.split("},");
        values = new double[strRow.length][];
        for (int i = 0, strRowLength = strRow.length; i < strRowLength; i++) {
            String row = strRow[i];
            row = row.replace("{", "")
                    .replace(" ", "")
                    .replace("}", "");
            String[] strings = row.split(",");
            values[i] = new double[strings.length];
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = Double.parseDouble(strings[j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] + scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix matrix) {
            double[][] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = values[i].clone();
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] + matrix.values[i][j];
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
            double[][] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] - scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix matrix) {
            double[][] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = values[i].clone();
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] - matrix.values[i][j];
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
            double[][] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] * scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector vector) {
            double[] result = new double[vector.getValues().length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i] = result[i] + values[i][j] * vector.getValues()[j];
                }
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }

    }

    public double[][] getValues() {
        return values.clone();
    }

    @Override
    public String toString() {
        return Arrays.deepToString(values).replaceAll("\\[", "{").replaceAll("]", "}");
    }
}
