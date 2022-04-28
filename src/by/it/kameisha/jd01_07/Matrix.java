package by.it.kameisha.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[ ][ ] value){
        double[][] array = new double[value.length][];
        for (int i = 0; i < value.length; i++) {
            array[i] = value[i].clone();
        }
        this.value = array;
    }

    public Matrix(Matrix matrix){
        double[][] array = new double[matrix.value.length][];
        for (int i = 0; i < matrix.value.length; i++) {
            array[i] = matrix.value[i].clone();
        }
        this.value = array;
    }

    public Matrix(String strMatrix){

    }

    @Override
    public String toString() {
        StringBuilder strValue = new StringBuilder("{");;
        for (int i = 0; i < value.length; i++) {
            String splitter = "";
            strValue.append("{");
            for (int j = 0; j < value[i].length; j++) {
                strValue.append(splitter).append(value[i][j]);
                splitter = ", ";
            }
            strValue.append("}");
            if(i == value.length-1){
                splitter = "";
            }
            strValue.append(splitter);
        }
        strValue.append("}");
        return strValue.toString();
    }
}
