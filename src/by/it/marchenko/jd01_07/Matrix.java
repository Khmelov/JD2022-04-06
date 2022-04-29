package by.it.marchenko.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    final String INCORRECT_INPUT_MESSAGE = "Incorrect matrix input";
    final String EMPTY_MATRIX_MESSAGE = "Matrix is empty";
    final String ROW_SEPARATOR = "},\\{";
    final String ELEMENT_SEPARATOR = ",";
    final int MATRIX_MEASURE = 2;
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
            // TODO check that length of all rows is the same
            double[][] tempArray = new double[stringRowArray.length][stringValueArray.length];
            for (int i = 0; i < stringRowArray.length; i++) {
                stringValueArray = stringRowArray[i].split(ELEMENT_SEPARATOR);
                for (int j = 0; j < stringValueArray.length; j++) {
                    tempArray[i][j] = Double.parseDouble(stringValueArray[j]);
                }
            }
            this.matrixValue = tempArray;
        } else {
            System.out.println(INCORRECT_INPUT_MESSAGE);
            this.matrixValue = null;
        }
    }

    @Override
    public String toString() {
        String stringMatrix = Arrays.deepToString(matrixValue);
        stringMatrix = stringMatrix.replaceAll(OPEN_SQUARE_BRACKET, OPEN_CURVE_BRACKET);
        stringMatrix = stringMatrix.replaceAll(CLOSE_SQUARE_BRACKET, CLOSE_CURVE_BRACKET);
        return stringMatrix;
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

}
