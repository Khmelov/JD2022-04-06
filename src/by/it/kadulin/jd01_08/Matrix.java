package by.it.kadulin.jd01_08;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {



    private final double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(Matrix matrix) {
        this.matrix = matrix.matrix;
    }

    public Matrix(String matrix) {
        Pattern pattern = Pattern.compile("},[ ]?\\{");
        Matcher matcher = pattern.matcher(matrix);
        int cols = 0;
        while (matcher.find()) {
            cols += 1;
        }
        cols += 1;
        String editedStr = matrix.replaceAll("},[ ]?\\{", " ").replaceAll("[{}]", "").replaceAll(",[ ]?", ",");
        String[] arrayOfRows = editedStr.split(" ");
        int rows = arrayOfRows[0].replaceAll(",", " ").split(" ").length;
        this.matrix = new double[cols][rows];
        for (int i = 0; i < this.matrix.length; i++) {
            String[] row = arrayOfRows[i].replaceAll(",", " ").split(" ");
            for (int j = 0; j < rows; j++) {
                this.matrix[i][j] = Double.parseDouble(row[j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = matrix[i][j] + scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        else if (other instanceof Matrix matrix2) {
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = matrix[i][j] + matrix2.matrix[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = matrix[i][j] - scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        else if (other instanceof Matrix matrix2) {
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = matrix[i][j] - matrix2.matrix[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = matrix[i][j] * scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        else if (other instanceof Vector vector) {
            double[] resultVector = new double[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    resultVector[i] = resultVector[i] + matrix[i][j] * vector.getValues()[j];
                }
            }
            return new Vector(resultVector);
        }
        else if (other instanceof Matrix matrix2) {
            double[][] resultMatrix = new double[matrix.length][matrix2.getMatrix()[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix2.getMatrix()[0].length; j++) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        resultMatrix[i][j] = resultMatrix[i][j] + matrix[i][k] * matrix2.getMatrix()[k][j]; //k нужно, чтобы перейти к след элемнту в изначальных матрицах
                    }
                }
            }
            return new Matrix(resultMatrix);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = matrix[i][j] / scalar.getValue();
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
    }

    public double[][] getMatrix() {
        return matrix.clone();
    }

    @Override
    public String toString() {
        StringJoiner sj1 = new StringJoiner(", ", "{", "}");
        for (int i = 0; i < matrix.length; i++) {
            StringJoiner sj2 = new StringJoiner(", ", "{", "}");
            for (int j = 0; j < matrix[0].length; j++) {
                sj2.add(Double.toString(matrix[i][j]));
            }
            sj1.add(sj2.toString());
        }
        return sj1.toString();
    }
}
