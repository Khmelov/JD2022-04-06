package by.it.kameisha.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value.clone();
    }

    public Vector(Vector vector) {
        this.value = vector.value.clone();
    }

    public Vector(String strVector) {
        strVector = strVector.replace("{", "");
        strVector = strVector.replace("}", "");
        String[] strings = strVector.split(",");
        double[] value = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            value[i] = Double.parseDouble(strings[i]);
        }
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder strValue = new StringBuilder("{");
        String splitter = "";
        for (double element : value) {
            strValue.append(splitter).append(element);
            splitter = ", ";
        }
        strValue.append("}");
        return strValue.toString();
    }
}
