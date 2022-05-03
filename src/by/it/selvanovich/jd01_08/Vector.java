package by.it.selvanovich.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

class Vector extends Var {
    private final double[] values;

    Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(Vector vector) {
        this.values = vector.values;
    }

    public Vector(String line) {
        line = line.replace("{", "");
        line = line.replace("}", "");
        StringTokenizer tokenizer = new StringTokenizer(line, ", ");
        int size = tokenizer.countTokens();
        values = new double[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(tokenizer.nextToken());
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + vector.values[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - vector.values[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var mul(Var other) {
        double mulResult = 0;
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                mulResult = mulResult + result[i] * vector.values[i];
            }
            return new Scalar(mulResult);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / scalar.getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }

    public double[] getValues() {
        return values.clone();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double value : values) {
            joiner.add(Double.toString(value));
        }
        return joiner.toString();
    }
}
