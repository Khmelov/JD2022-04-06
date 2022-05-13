package by.it.marchenko.calc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static by.it.marchenko.calc.MessageConst.*;

public class Matrix extends Var {
    final String INCORRECT_INPUT_MESSAGE = "Incorrect matrix input";
    final String EMPTY_MATRIX_MESSAGE = "Matrix is empty";
    final String ROW_SEPARATOR = "},\\{";
    final String ELEMENT_SEPARATOR = ",";
    final int MATRIX_MEASURE = 2;
    final String OPEN_CURVE_BRACKET = "{";
    final String CLOSE_CURVE_BRACKET = "}";
    final String OPEN_SQUARE_BRACKET = "\\[";
    final String CLOSE_SQUARE_BRACKET = "]";

    private final double[][] matrixValue;

    public Matrix(double[][] matrixValue) {
        if (checkInputMatrix(matrixValue)) {
            double[][] tempMatrix = new double[matrixValue.length][matrixValue[0].length];
            for (int i = 0; i < matrixValue.length; i++) {
                System.arraycopy(matrixValue[i], 0, tempMatrix[i], 0, matrixValue[i].length);
            }
            this.matrixValue = tempMatrix;
        } else {
            this.matrixValue = null;
        }
    }

    public Matrix(Matrix matrix) {
        if (checkInputMatrix(matrix.matrixValue)) {
            double[][] tempMatrix = new double[matrix.matrixValue.length][matrix.matrixValue[0].length];
            for (int i = 0; i < matrix.matrixValue.length; i++) {
                System.arraycopy(matrix.matrixValue[i], 0, tempMatrix[i],
                        0, matrix.matrixValue[i].length);
            }
            this.matrixValue = tempMatrix;
        } else {
            this.matrixValue = null;
        }
    }

    public Matrix(String stringMatrix) {
        stringMatrix = stringMatrix.replaceAll("\s", "");
        int startDoubleCurvePosition = stringMatrix.indexOf(OPEN_CURVE_BRACKET.repeat(MATRIX_MEASURE));
        int endDoubleCurvePosition = stringMatrix.indexOf(CLOSE_CURVE_BRACKET.repeat(MATRIX_MEASURE));
        int endDoubleCurveCorrectPosition = stringMatrix.length() - MATRIX_MEASURE;

        if (stringMatrix.length() > 0 && startDoubleCurvePosition == 0 &&
                endDoubleCurvePosition == endDoubleCurveCorrectPosition) {

            stringMatrix = stringMatrix.substring(MATRIX_MEASURE, endDoubleCurveCorrectPosition);
            String[] stringRowArray = stringMatrix.split(ROW_SEPARATOR);
            String[] stringValueArray = stringRowArray[0].split(ELEMENT_SEPARATOR);

            int tempRowLength = stringValueArray.length;
            boolean isTheSameLength = true;

            double[][] tempArray = new double[stringRowArray.length][tempRowLength];
            for (int i = 0; i < stringRowArray.length; i++) {
                stringValueArray = stringRowArray[i].split(ELEMENT_SEPARATOR);
                if (tempRowLength == stringValueArray.length) {
                    for (int j = 0; j < stringValueArray.length; j++) {
                        tempArray[i][j] = Double.parseDouble(stringValueArray[j]);
                    }
                } else {
                    System.out.println(INCORRECT_INPUT_MESSAGE);
                    isTheSameLength = false;
                    break;
                }

            }
            if (isTheSameLength) {
                this.matrixValue = tempArray;
            } else {
                this.matrixValue = null;
            }
        } else {
            System.out.println(INCORRECT_INPUT_MESSAGE);
            this.matrixValue = null;
        }
    }

    public double[][] getMatrixValue() {
        Matrix tempMatrix = new Matrix(this);
        return tempMatrix.matrixValue;
    }

    @Override
    public String toString() {
        String stringMatrix = Arrays.deepToString(matrixValue);
        stringMatrix = stringMatrix.replaceAll(OPEN_SQUARE_BRACKET, OPEN_CURVE_BRACKET);
        stringMatrix = stringMatrix.replaceAll(CLOSE_SQUARE_BRACKET, CLOSE_CURVE_BRACKET);
        return stringMatrix;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Зашли сюда как Matrix+Var");
        Object tempResult = this;
        try {
            Method method = this.getClass().getMethod(ADD_STRING_OPERATOR, other.getClass());
            tempResult = method.invoke(this, other);
        } catch (NoSuchMethodException e) {
            return super.add(other);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;
    }

    public Var add(Scalar other) {
        System.out.println("Зашли сюда как Matrix + Scalar");
        double[][] tempMatrix = this.getMatrixValue();
        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix[i].length; j++) {
                tempMatrix[i][j] += other.getValue();
            }
        }
        return new Matrix(tempMatrix);
    }

    public Var add(Matrix other) {
        System.out.println("Зашли сюда как Matrix + Matrix");
        double[][] tempMatrix = this.getMatrixValue();
        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix[i].length; j++) {
                tempMatrix[i][j] += other.matrixValue[i][j];
            }
        }
        return new Matrix(tempMatrix);
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Зашли сюда как Matrix*Var");
        Object tempResult = this;
        try {
            Method method = this.getClass().getMethod(MUL_STRING_OPERATOR, other.getClass());
            tempResult = method.invoke(this, other);
        } catch (NoSuchMethodException e) {
            return super.mul(other);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;
    }

    public Var mul(Scalar other) {
        System.out.println("Зашли сюда как Matrix*Scalar");
        double[][] tempMatrix = this.getMatrixValue();
        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix[i].length; j++) {
                tempMatrix[i][j] *= other.getValue();
            }
        }
        return new Matrix(tempMatrix);
    }

    public Var mul(Vector other) {
        System.out.println("Зашли сюда как Matrix*Vector");
        double[][] tempMatrix = this.getMatrixValue();
        return new Vector(calculateMatrixMultiply(tempMatrix, other.getVectorValues()));
    }

    public Var mul(Matrix other) {
        System.out.println("Зашли сюда как Matrix*Matrix");
        double[][] tempMatrix = this.getMatrixValue();
        return new Matrix(calculateMatrixMultiply(tempMatrix, other.matrixValue));
    }

    @Override
    public Var sub(Var other) {
        final Scalar MINUS_ONE = new Scalar(-1d);
        System.out.println("Зашли сюда как Matrix-Var");
        Object tempResult = this;
        try {
            Method methodMul = other.getClass().
                    getMethod(MUL_STRING_OPERATOR, MINUS_ONE.getClass());
            tempResult = methodMul.invoke(other, MINUS_ONE);
            Method methodAdd = this.getClass().getMethod(ADD_STRING_OPERATOR, other.getClass());
            tempResult = methodAdd.invoke(this, tempResult);
        } catch (NoSuchMethodException e) {
            return super.sub(other);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;






/*
        if (other instanceof Scalar otherScalar) {
            double[][] tempMatrix = this.getMatrixValue();
            for (int i = 0; i < tempMatrix.length; i++) {
                for (int j = 0; j < tempMatrix[i].length; j++) {
                    tempMatrix[i][j] -= otherScalar.getValue();
                }
            }
            return new Matrix(tempMatrix);
        } else if (other instanceof Matrix otherMatrix) {
            double[][] tempMatrix = this.getMatrixValue();
            for (int i = 0; i < tempMatrix.length; i++) {
                for (int j = 0; j < tempMatrix[i].length; j++) {
                    tempMatrix[i][j] -= otherMatrix.matrixValue[i][j];
                }
            }
            return new Matrix(tempMatrix);
        } else {
            return super.sub(other);

        }
*/
    }

    @Override
    public Var div(Var other) {
        System.out.println("Зашли сюда как Matrix/Var");
        Object tempResult = this;
        try {
            Method method = this.getClass().getMethod(DIV_STRING_OPERATOR, other.getClass());
            tempResult = method.invoke(this, other);
        } catch (NoSuchMethodException e) {
            return super.div(other);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (Var) tempResult;
    }

    public Var div(Scalar other) {
        System.out.println("Зашли сюда как Matrix/Scalar");
        double[][] tempMatrix = this.getMatrixValue();
        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix[i].length; j++) {
                tempMatrix[i][j] /= other.getValue();
            }
        }
        return new Matrix(tempMatrix);
    }

    private boolean checkInputMatrix(double[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            System.out.println(EMPTY_MATRIX_MESSAGE);
            return false;
        }
        int tempHeight = array[0].length;
        for (double[] row : array) {
            if (tempHeight != row.length) {
                System.out.println(INCORRECT_INPUT_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private static double[][] calculateMatrixMultiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] matrixResult = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; ++i) {
            for (int j = 0; j < matrixRight[0].length; ++j) {
                for (int iterator = 0; iterator < matrixRight.length; ++iterator) {
                    matrixResult[i][j] += matrixLeft[i][iterator] * matrixRight[iterator][j];
                }
            }
        }
        return matrixResult;
    }

    static double[] calculateMatrixMultiply(double[][] matrix, double[] vector) {
        double[] vectorResult = new double[matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int iterator = 0; iterator < vector.length; ++iterator) {
                vectorResult[i] += matrix[i][iterator] * vector[iterator];
            }
        }
        return vectorResult;
    }


}
