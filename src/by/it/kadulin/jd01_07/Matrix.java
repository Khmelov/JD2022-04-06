package by.it.kadulin.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var{
    private final double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(Matrix matrix) {
        this.matrix = matrix.matrix;
    }

    public Matrix(String matrix) {
        Pattern pattern = Pattern.compile("},\\{");
        Matcher matcher = pattern.matcher(matrix);
        int cols = 0;
        while (matcher.find()) {
            cols += 1;
        }
        cols += 1;
        String editedStr = matrix.replaceAll("},\\{", " ").replaceAll("[{}]", "");
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < matrix.length; i++) {
            sb.append("{");
            for (int j = 0; j < matrix[0].length; j++) {
                if (j != matrix[0].length - 1) {
                    sb.append(matrix[i][j]).append(" ,");
                }
                else {
                    sb.append(matrix[i][j]).append("}");
                }
            }
            if (i == matrix.length - 1) {
                sb.append("}");
            }
            else {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
