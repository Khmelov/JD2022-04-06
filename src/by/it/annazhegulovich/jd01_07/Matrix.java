package by.it.annazhegulovich.jd01_07;

import java.util.Arrays;
import java.util.StringJoiner;

class Matrix extends Var {

    private final double[][] value2;

    public Matrix(double[][] value) {
        value2 = new double[value.length][value.length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                value2 [i][j] = value [i][j];
            }
        }
    }
    public Matrix(Matrix matrix){
        this.value2= matrix.value2;
    }
    public Matrix(String strMatrix){
strMatrix = strMatrix.replace("{"," ")
                     .replace("}"," ")
                     .replace("  ", " ")
                     .replace(" , ", ", ");
strMatrix = strMatrix.trim();
        String [] res= strMatrix.split("[, ]");
        String [][] strM= new String[res.length][];
        for (int i = 0; i <strM.length ; i++) {
                strM[i]=res [i].split(", ");
        }
        double[][] strM2=new double[strM.length][];
        for (int i = 0; i <strM2.length ; i++) {
            for (int j = 0; j < strM[0].length; j++) {
                strM2[i][j] = Double.parseDouble(strM[i][j]);
            }
        }
        this.value2=strM2;
    }

    @Override
    public String toString() {
        String strMatrix = new String();
        for (int i = 0; i < value2.length; i++) {
            strMatrix += "{";
            for (int j = 0; j < value2.length; j++) {
                strMatrix += Double.toString(value2[i][j]);
                if (j != value2.length - 1) {
                    strMatrix += ", ";
                }
            }
            strMatrix = strMatrix + "}";
            if (i != value2.length - 1) {
                strMatrix += ", ";
            }
        }
        return  "{"+strMatrix.toString()+"}";
    }
}
