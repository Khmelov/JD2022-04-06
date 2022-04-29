package by.it.machuga.jd01_07;

import static by.it.machuga.jd01_07.Converter.*;

class Vector extends Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = value.clone();
    }

    Vector(Vector vector) {
        this.value = vector.value.clone();
    }

    Vector(String strVector) {
        this.value = convertStringToDoubleArray(strVector);
    }

    @Override
    public String toString() {
        return convertDoubleArrayToString(value);
    }


}
