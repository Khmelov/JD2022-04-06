package by.it.smirnov.jd01_08;

import java.util.Arrays;

class Matrix extends Var {

    private final double[][] values;

    Matrix(double[][] values) {
        this.values = values;
        for (int i = 0; i < values.length; i++) {
            this.values[i] = Arrays.copyOf(values[i],values[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this.values = matrix.values;
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("\\s", "").replaceAll("\\{\\{", "").replaceAll("}}", "");
        String[] array = strMatrix.split("},\\{");
        String[][] multiArray = new String[array.length][];
        double[][] toDouble = new double[array.length][];
        for (int i = 0; i < multiArray.length; i++) {
            multiArray[i] = array[i].split(",");
            double[] buffer = new double[multiArray[i].length];
            for (int j = 0; j < multiArray[i].length; j++) {
                buffer[j] = Double.parseDouble(multiArray[i][j]);
            }
            toDouble[i] = buffer;
        }
        this.values = toDouble;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String newdelim = "";
        for (int i = 0; i < values.length; i++) {
            sb.append(newdelim).append("{");
            String delimiter = "";
            for (int j = 0; j < values[i].length; j++) {
                sb.append(delimiter).append(values[i][j]);
                delimiter = ", ";
                }
            newdelim = "}, ";
        }
        sb.append("}}");
        return sb.toString();
    }
}

