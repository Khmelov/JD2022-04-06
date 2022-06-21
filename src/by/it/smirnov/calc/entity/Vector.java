package by.it.smirnov.calc.entity;

import by.it.smirnov.calc.exception.CalcException;

import java.util.Arrays;
import java.util.StringJoiner;

public class Vector extends Var {

    private final double[] values;

    public double[] getValues() {
        return this.values.clone();
    }

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Vector(Vector vector) {
        this(vector.values);
    }

    public Vector(String strVector) {
        strVector = strVector.replaceAll("\\{", "").replaceAll("}", "").replaceAll("\\s", "");
                String[] fromString = strVector.split(",");
        double[] toDouble = new double[fromString.length];
        for (int i = 0; i < toDouble.length; i++) {
            toDouble[i] = Double.parseDouble(fromString[i]);
        }
        this.values = toDouble;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "{", "}");
        for (double elem:
             values) {
            if (Math.round(elem) == elem) {
                sj.add(String.valueOf((int)elem));
            }
            else {
                sj.add(String.valueOf(elem));
            }
        }
        return sj.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] add = Arrays.copyOf(values, values.length);
            for (int i = 0; i < this.values.length; i++) {
                add[i] = add[i] + ((Scalar) other).getValue();
            }
            return new Vector(add);
        }
        else if (other instanceof Vector vector) {
            if (this.values.length != vector.values.length) {
                throw new CalcException("Incorrect size for %s + %s", this, vector);
            }
            double[] add = Arrays.copyOf(values, values.length);
            for (int i = 0; i < add.length; i++) {
                add[i] = add[i] + ((Vector) other).values[i];
            }
            return new Vector(add);
        }

        else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return this.add(new Scalar(-1).mul(other));
        }
        else if (other instanceof Vector) {
            double[] sub = Arrays.copyOf(values, values.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] = sub[i] - ((Vector) other).values[i];
            }
            return new Vector(sub);
        }
        else return other.sub(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] mul = Arrays.copyOf(values, values.length);
            for (int i = 0; i < this.values.length; i++) {
                mul[i] = mul[i] * ((Scalar) other).getValue();
            }
            return new Vector(mul);
        }
        else if (other instanceof Vector) {
            double[] mul = Arrays.copyOf(values, values.length);
            double addmul = 0.0;
            for (int i = 0; i < this.values.length; i++) {
                mul[i] = mul[i] * ((Vector) other).values[i];
                addmul = addmul + mul[i];
            }
            return new Scalar(addmul);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if(((Scalar) other).getValue() == 0)
                throw new CalcException("Деление на ноль невозможно!");
            double[] div = Arrays.copyOf(values, values.length);
            for (int i = 0; i < this.values.length; i++) {
                div[i] = div[i] / ((Scalar) other).getValue();
            }
            return new Vector(div);
        }
        else return super.div(other);
    }
}
