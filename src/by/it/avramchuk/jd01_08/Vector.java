package by.it.avramchuk.jd01_08;

import java.util.Arrays;

public class Vector extends Var {
   private final double[] values ;

    public Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(Vector vector) {
        this.values = vector.values.clone();
    }

    public Vector(String strVector) {
        strVector=strVector.replaceAll("[^.0-9]", " ");
        strVector=strVector.trim();
        String[] newStr = strVector.split("\s+");
        this.values = new double[newStr.length];
        for (int i = 0; i < newStr.length; i++) {
            this.values[i]= Double.parseDouble(newStr[i]);
        }
    }

    public double[] getValues() {
        return values.clone();
    }

    @Override
    public String toString() {
        return Arrays.toString(values).
                replaceAll("\\[","{").
                replaceAll("]","}");
    }
}
