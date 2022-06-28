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

        String [] res= strMatrix.split("},");
        this.value2 = new double[res.length][];
        for (int i = 0; i <res.length ; i++) {
            String strRes= res[i];
            strRes = strRes.replace("{","")
                            .replace("}","")
                            .replace(" ","");
            String [] resi= strRes.split(",");
            value2[i]=new  double[resi.length];
            for (int j = 0; j < value2[i].length; j++) {
                this.value2[i][j]= Double.parseDouble(resi[j]);
            }
        }
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
