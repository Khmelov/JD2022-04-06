package by.it.machuga.calc.operationExecutops;

import by.it.machuga.calc.entity.Matrix;
import by.it.machuga.calc.entity.Scalar;
import by.it.machuga.calc.entity.Vector;

public class Multiplicator {

    public static Matrix mulMatrixByMatrix(Matrix leftMatrix, Matrix rightMatrix) {
        double[][] resultMatrix = new double[leftMatrix.getValue().length][rightMatrix.getValue()[0].length];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                double sum = 0.0;
                for (int k = 0; k < leftMatrix.getValue()[i].length; k++) {
                    sum += leftMatrix.getValue()[i][k] * rightMatrix.getValue()[k][j];
                }
                resultMatrix[i][j] = sum;
            }
        }
        return new Matrix(resultMatrix);
    }

    public static Vector mulMatrixByVector(Matrix matrix, Vector vector) {
        double[] resultMatrix = new double[matrix.getValue().length];
        for (int i = 0; i < resultMatrix.length; i++) {
            double sum = 0.0;
            for (int j = 0; j < matrix.getValue()[i].length; j++) {
                sum += matrix.getValue()[i][j] * vector.getValue()[j];
            }
            resultMatrix[i] = sum;
        }
        return new Vector(resultMatrix);
    }

    public static Matrix mulMatrixByScalar(Matrix matrix, Scalar scalar) {
        double[][] result = new double[matrix.getValue().length][matrix.getValue()[0].length];
        for (int i = 0; i < matrix.getValue().length; i++) {
            for (int j = 0; j < matrix.getValue()[0].length; j++) {
                result[i][j] = matrix.getValue()[i][j] * scalar.getValue();
            }
        }
        return new Matrix(result);
    }

    public static Scalar mulVectorByVector(Vector leftVector, Vector rightVector) {
        double result = 0;
        for (int i = 0; i < leftVector.getValue().length; i++) {
            result += leftVector.getValue()[i] * rightVector.getValue()[i];
        }
        return new Scalar(result);
    }

    public static Vector mulVectorByScalar(Vector vector, Scalar scalar) {
        double[] result = new double[vector.getValue().length];
        for (int i = 0; i < vector.getValue().length; i++) {
            result[i] = vector.getValue()[i] * scalar.getValue();
        }
        return new Vector(result);
    }

    public static Scalar mulScalarByScalar(Scalar leftScalar, Scalar rightScalar) {
        return new Scalar(leftScalar.getValue() * rightScalar.getValue());
    }
}
