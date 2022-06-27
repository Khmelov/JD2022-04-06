package by.it.arsenihlaz.Calculator.entity;

import by.it.arsenihlaz.Calculator.exception.CalcException;

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
        String strVectornew = strVector.replaceAll("[{}]", "");
        String[] arrayStrVector = strVectornew.split(",");
        this.value = new double[arrayStrVector.length].clone();
        for (int i = 0; i < arrayStrVector.length; i++) {
            this.value[i] = Double.parseDouble(arrayStrVector[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] += scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            if (this.value.length != vector.value.length) {
                throw new CalcException("Incorrect size for %s + %s", this, vector);
            }
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] += vector.value[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] -= scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] -= vector.value[i];
            }
            return new Vector(result);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] *= scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            double[] mul = value.clone();
            double result = 0;
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= vector.value[i];
                result += mul.clone()[i];
            }
            return new Scalar(result);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] /= scalar.getValue();
            }
            return new Vector(result);
        } else return super.div(other);
    }

    @Override
    public String toString() {
        String stringArrays = Arrays.toString(value);
        stringArrays = stringArrays.replaceAll("[\\[]", "{");
        stringArrays = stringArrays.replaceAll("[\\]]", "}");
        return stringArrays;
    }

    public double[] getValue() {
        return value.clone();
    }
}
