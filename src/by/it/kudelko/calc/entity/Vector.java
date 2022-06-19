package by.it.kudelko.calc.entity;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private double[] values;

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Vector(Vector vector) {
        this(vector.values);
    }

    public Vector(String strVector) {
        StringBuffer str1 = new StringBuffer(strVector);
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()) {
            int startPosition = matcher.start();
            int lastPosition = str1.length() - 1;
            str1.setCharAt(startPosition, ' ');
            str1.setCharAt(lastPosition, ' ');
        }
        String str2 = str1.toString();
        str2 = str2.trim();
        String strArr[] = str2.split(",");
        double numArr[] = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Double.parseDouble(strArr[i]);
            this.values = numArr;
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
        } else {
            if (other instanceof Vector vector) {
                double[] result = values.clone();
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i] + vector.values[i];
                }
                return new Vector(result);
            } else {
                return super.add(other);
            }
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
        } else {
            if (other instanceof Vector vector) {
                double[] result = values.clone();
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i] - vector.values[i];
                }
                return new Vector(result);
            } else {
                return super.sub(other);
            }
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * scalar.getValue();
            }
            return new Vector(result);
        } else {
            if (other instanceof Vector vector) {
                double[] result = values.clone();
                double sum = 0;
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i] * vector.values[i];
                    sum = sum + result[i];
                }
                return new Scalar(sum);
            } else {
                return super.mul(other);
            }
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
        } else {
            if (other instanceof Vector vector) {
                return super.div(other);
            }
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimeter = "";
        for (double element : values) {
            sb.append(delimeter).append(element);
            delimeter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
