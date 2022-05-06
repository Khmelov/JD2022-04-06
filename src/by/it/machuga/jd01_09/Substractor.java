package by.it.machuga.jd01_09;

public class Substractor {

    public static Matrix subMatrixFromMatrix(Matrix leftMatrix, Matrix rightMatrix) {
        double[][] result = new double[leftMatrix.getValue().length][leftMatrix.getValue()[0].length];
        for (int i = 0; i < leftMatrix.getValue().length; i++) {
            for (int j = 0; j < leftMatrix.getValue()[0].length; j++) {
                result[i][j] = leftMatrix.getValue()[i][j] - rightMatrix.getValue()[i][j];
            }
        }
        return new Matrix(result);
    }

    public static Matrix subScalarFromMatrix(Matrix matrix, Scalar scalar) {
        double[][] result = new double[matrix.getValue().length][matrix.getValue()[0].length];
        for (int i = 0; i < matrix.getValue().length; i++) {
            for (int j = 0; j < matrix.getValue()[0].length; j++) {
                result[i][j] = matrix.getValue()[i][j] - scalar.getValue();
            }
        }
        return new Matrix(result);
    }

    public static Vector subVectorFromVector(Vector leftVector, Vector rightVector) {
        double[] result = new double[leftVector.getValue().length];
        for (int i = 0; i < leftVector.getValue().length; i++) {
            result[i] = leftVector.getValue()[i] - rightVector.getValue()[i];
        }
        return new Vector(result);
    }

    public static Vector subScalarFromVector(Vector vector, Scalar scalar) {
        double[] result = new double[vector.getValue().length];
        for (int i = 0; i < vector.getValue().length; i++) {
            result[i] = vector.getValue()[i] - scalar.getValue();
        }
        return new Vector(result);
    }

    public static Scalar subScalarFromScalar(Scalar leftScalar, Scalar rightScalar) {
        return new Scalar(leftScalar.getValue() - rightScalar.getValue());
    }
}
