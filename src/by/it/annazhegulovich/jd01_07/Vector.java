package by.it.annazhegulovich.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] values;


    public Vector(double[] values) {
        this.values = values.clone();
    }

    public double[] getValues() {
        return values;
    }
    /*public void StringArr (String[] strValues) {
        strValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            strValues[i] = String.join( ", ", strValues[i]);
        }
    }*/
    @Override
    public String toString() {
        String[] strValues = new String[values.length];
        for (int i = 0; i < strValues.length; i++) {
            strValues[i] = String.valueOf(values[i]);
        }
        String arr = String.join( ", ", strValues);
        return  "{"+arr+"}";
    }
}
