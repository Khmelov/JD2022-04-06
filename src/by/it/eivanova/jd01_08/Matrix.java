package by.it.eivanova.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    final double[][] values;
    public Matrix(double[][] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Matrix (Matrix matrix){
        this.values = matrix.values;
    }


    public Matrix(String strMatrix){
        String[] strRow = strMatrix.split("},");
        values= new double[strRow.length][];
        for (int i = 0, strRowLength = strRow.length; i < strRowLength; i++) {
            String row = strRow[i];
            row = row.replace("{", "").replace(" ", "").replace("}", "");


            String[] strings = row.split(",");
            values[i] = new double[strings.length];
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = Double.parseDouble(strings[j]);

            }
        }
    }

    //сложение
    @Override
    public Var add(Var other) {
        return super.add(other);
                }


                //вычитание
                @Override
                public Var sub (Var other){
                    return super.sub(other);
                }


                //умножение
                @Override
                public Var mul (Var other){
                    return super.mul(other);
                }


                //деление
                @Override
                public Var div (Var other){
                    return super.div(other);
                }

                @Override
                public String toString () {
                    String stringArrays = Arrays.deepToString(values);
                    stringArrays = stringArrays.replaceAll("[\\[]", "{");
                    stringArrays = stringArrays.replaceAll("[\\]]", "}");
                    return stringArrays;
                }
            }