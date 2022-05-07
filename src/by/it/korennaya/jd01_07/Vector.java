package by.it.korennaya.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] values;

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public double[] getValues() {
        return this.values.clone();
    }

    @Override
    public String toString() {
        return "Vector{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}