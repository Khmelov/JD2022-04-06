package by.it.selvanovich.jd01_07;

import java.util.ArrayList;
import java.util.Arrays;

class Vector extends Var{
    private final double[] values;

    Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(Vector vector) {
        this.values = vector.values;
    }

    public Vector(String line) {
        line = line.replace("{","");
        line = line.replace("}","");
        String[] strings = line.split(",");
        this.values = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            this.values[i]=Double.parseDouble(strings[i]);
        }
    }

    public double[] getValues() {
        return values.clone();
    }

    @Override
    public String toString() {
        return Arrays.toString(values).replaceAll("\\[","{").replaceAll("]","}");
    }
}
