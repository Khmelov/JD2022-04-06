package by.it.avramchuk.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private  final double[][] value;

    public Matrix(double[][] value) {
        this.value = value.clone();
        for (int i = 0; i < value.length; i++) {
            this.value[i] = value[i].clone();
        }
    }

    public Matrix (Matrix matrix){
        this.value = matrix.value.clone();
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = matrix.value[i].clone();
        }
    }

    public Matrix (String strMatrix){
        String[]mainStr = strMatrix.split("},|}\\s+,");
        String[][] res = new  String[mainStr.length][];
        for (int i = 0; i < mainStr.length ; i++) {
            mainStr[i] = mainStr[i].replaceAll("[^.0-9]", " ");
            mainStr[i] = mainStr[i].trim();
            res[i]=mainStr[i].split("\s+");
        }

        this.value = new double[res.length][res[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                this.value[i][j]=Double.parseDouble(res[i][j]);
            }
        }
    }

    public double[][] getValue() {
        double[][] res = this.value.clone();
        for (int i = 0; i < this.value.length; i++) {
            res[i] = this.value[i].clone();
        }
        return res;
    }

    @Override
    public String toString() {
        String str = "{";
        for (int i = 0; i < value.length; i++) {
            str = str.concat(Arrays.toString(value[i]).
                    replaceAll("\\[","{").
                    replaceAll("]","}"));
            if (i!= value.length-1){
                str=str.concat(", ");
            }
        }
        str= str+"}";
        return str;
    }
}
