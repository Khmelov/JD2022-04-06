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

    //public Vector(String stringVector) {

        //stringVector.split(VECTOR_SEPARATOR);
        //stringVector.ch
    //this.value = Arrays.copyOf(vector.value, vector.value.length);
    //}


    @Override
    public String toString() {
        StringBuffer outputString = new StringBuffer(Arrays.toString(value));
        outputString.setCharAt(0, OPEN_CURVE_BRACKET);
        outputString.setCharAt(outputString.length() - 1, CLOSE_CURVE_BRACKET);
        return outputString.toString();
    }
}
