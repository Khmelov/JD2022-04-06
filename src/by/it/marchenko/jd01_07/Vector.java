package by.it.marchenko.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    public Vector(String stringVector) {
        stringVector = stringVector.substring(1, stringVector.length() - 1);
        String[] stringValuesArray = stringVector.split(SEPARATOR);
        double[] tempDoubleArray = new double[stringValuesArray.length];
        for (int i = 0; i < stringValuesArray.length; i++) {
            tempDoubleArray[i] = Double.parseDouble(stringValuesArray[i]);
        }
        this.value = Arrays.copyOf(tempDoubleArray, tempDoubleArray.length);
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder(Arrays.toString(value));
        outputString.setCharAt(0, OPEN_CURVE_BRACKET);
        outputString.setCharAt(outputString.length() - 1, CLOSE_CURVE_BRACKET);
        return outputString.toString();
    }
}
