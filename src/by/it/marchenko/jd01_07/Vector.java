package by.it.marchenko.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    final String INCORRECT_INPUT_MESSAGE = "Incorrect vector input";
    private final double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    public Vector(String stringVector) {
        if (stringVector.indexOf(OPEN_CURVE_BRACKET) == 0 &&
                stringVector.indexOf(CLOSE_CURVE_BRACKET) == stringVector.length() - 1) {
            stringVector = stringVector.substring(1, stringVector.length() - 1);
            String[] stringValuesArray = stringVector.split(SEPARATOR);
            double[] tempDoubleArray = new double[stringValuesArray.length];
            for (int i = 0; i < stringValuesArray.length; i++) {
                tempDoubleArray[i] = Double.parseDouble(stringValuesArray[i]);
            }
            this.value = Arrays.copyOf(tempDoubleArray, tempDoubleArray.length);
        } else {
            System.out.println(INCORRECT_INPUT_MESSAGE);
            this.value = null;
        }


    }

    @Override
    public String toString() {
        String outputString = Arrays.toString(value);
        outputString = outputString.replaceAll(OPEN_SQUARE_BRACKET,OPEN_CURVE_BRACKET);
        outputString = outputString.replaceAll(CLOSE_SQUARE_BRACKET,CLOSE_CURVE_BRACKET);
        return outputString;
    }
}
