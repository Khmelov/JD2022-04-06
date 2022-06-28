package by.it.korennaya.jd01_09;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Vector extends Var {

    private final double[] values;

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }
    public Vector(Vector vector) {
        this(vector.values);
    }

    public Vector(String strVector) {
        strVector = strVector
                .replace("{", "")
                .replace("}", "");
        StringTokenizer tokenizer = new StringTokenizer(strVector, ", ");
        int size = tokenizer.countTokens();
        values = new double[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(tokenizer.nextToken());
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + vector.values[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }
    public double[] getValues() {
        return this.values.clone();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double value : values) {
            joiner.add(Double.toString(value));
        }
        return joiner.toString();
    }
}
