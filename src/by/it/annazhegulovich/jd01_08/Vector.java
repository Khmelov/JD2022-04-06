package by.it.annazhegulovich.jd01_08;

import java.util.StringTokenizer;

public class Vector extends Var {

    private final double[] values;


    public Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(Vector vector){
        this.values=vector.values;
    }



     public Vector(String strVector) {
        strVector = strVector.replace("{", "")
                             .replace("}", "");
         StringTokenizer tokenizer = new StringTokenizer(strVector, ", ");
         int size = tokenizer.countTokens();
         values = new double[size];
         for (int i = 0; i < values.length; i++) {
             values [i] = Double.parseDouble(tokenizer.nextToken());
         }
    }

    public double[] getValues() {
        return this.values.clone();
    }


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
