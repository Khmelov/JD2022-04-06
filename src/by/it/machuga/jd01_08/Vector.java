package by.it.machuga.jd01_08;

import static by.it.machuga.jd01_08.Converter.convertDoubleArrayToString;
import static by.it.machuga.jd01_08.Converter.convertStringToDoubleArray;

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

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] + ((Vector) other).value[i];
            }
            return new Vector(result);
        } else if (other instanceof Scalar) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        } else if (other instanceof Scalar) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double result = 0;
            for (int i = 0; i < this.value.length; i++) {
                result += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(result);
        } else if (other instanceof Scalar) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar && ((Scalar) other).getValue() != 0) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return convertDoubleArrayToString(value);
    }
}
