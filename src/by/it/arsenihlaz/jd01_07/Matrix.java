package by.it.arsenihlaz.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;
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
    public String toString() {
        String stringArrays = Arrays.deepToString(value);
        stringArrays = stringArrays.replaceAll("[\\[]", "{");
        stringArrays = stringArrays.replaceAll("[\\]]", "}");
        return stringArrays;
    }
}

