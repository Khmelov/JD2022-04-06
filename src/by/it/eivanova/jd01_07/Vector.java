package by.it.eivanova.jd01_07;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Vector extends Var {

    private final double[] values;


    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
     //   this.values = values.clone();
    }


    public Vector (Vector vector){
        this.values = vector.values;
    }


    public Vector(String strVector){
        strVector =strVector.replace("{", "");
        strVector =strVector.replace("}", "");

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
    public String toString () {
        StringBuilder out = new StringBuilder();
        out.append("{");
        String delimiter = "";
        for (double element : values) {
            out.append(delimiter).append(element);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }
}
