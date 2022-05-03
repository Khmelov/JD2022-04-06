package by.it._classwork_.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {


    double[][] values;

    public Matrix(String str) {
        //{{1,2,3},{4,5,6}}
        String[] strRow = str.split("},");
        values = new double[strRow.length][];
        for (int i = 0, strRowLength = strRow.length; i < strRowLength; i++) {
            String row = strRow[i];
            row = row.replace("{", "")
                    .replace(" ", "")
                    .replace("}", "");
            String[] strings = row.split(",");
            values[i]=new double[strings.length];
            for (int j = 0; j < values[i].length; j++) {
                values[i][j]=Double.parseDouble(strings[j]);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(values);
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix("{{1,2,3},{4,5,6}}");
        System.out.println(matrix);
    }
}
