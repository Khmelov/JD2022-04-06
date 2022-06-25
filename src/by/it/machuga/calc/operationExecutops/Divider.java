package by.it.machuga.calc.operationExecutops;

import by.it.machuga.calc.entity.Matrix;
import by.it.machuga.calc.entity.Scalar;
import by.it.machuga.calc.entity.Vector;

public class Divider {

    public static Matrix divMatrixByScalar(Matrix matrix, Scalar scalar) {
        double[][] result = new double[matrix.getValue().length][matrix.getValue()[0].length];
        for (int i = 0; i < matrix.getValue().length; i++) {
            for (int j = 0; j < matrix.getValue()[0].length; j++) {
                result[i][j] = matrix.getValue()[i][j] / scalar.getValue();
            }
        }
        return new Matrix(result);
    }

    public static Vector divVectorByScalar(Vector vector, Scalar scalar) {
        double[] result = new double[vector.getValue().length];
        for (int i = 0; i < vector.getValue().length; i++) {
            result[i] = vector.getValue()[i] / scalar.getValue();
        }
        return new Vector(result);
    }

    public static Scalar divScalarByScalar(Scalar leftScalar, Scalar rightScalar) {
        return new Scalar(leftScalar.getValue() / rightScalar.getValue());
    }
}
