package by.it.marchenko.jd01_08;

import java.util.Arrays;

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
            if (isTheSameLength){
                this.matrixValue = tempArray;
            } else {
                this.matrixValue = null;
            }
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
