package by.it.smirnov.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private final double[] values;

    Vector(double[] values) {
        this.values = values.clone();
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("\\{", "").replaceAll("}", "").replaceAll("\\s", "");
                String[] fromString = strVector.split(",");
        double[] toDouble = new double[fromString.length];
        for (int i = 0; i < toDouble.length; i++) {
            toDouble[i] = Double.parseDouble(fromString[i]);
        }
        this.values = toDouble;
    }

    Vector(Vector vector) {
        this.values = vector.values;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double elem:
             values) {
            sb.append(delimiter).append(elem);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] add = Arrays.copyOf(values, values.length);
            for (int i = 0; i < this.values.length; i++) {
                add[i] = add[i] + ((Scalar) other).getValue();
            }
            return new Vector(add);
        }
        else if (other instanceof Vector) {
            double[] add = Arrays.copyOf(values, values.length);
            for (int i = 0; i < add.length; i++) {
                add[i] = add[i] + ((Vector) other).values[i];
            }
            return new Vector(add);
        }

        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
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
    public Var mul(Var other) {
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
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] div = Arrays.copyOf(values, values.length);
            for (int i = 0; i < this.values.length; i++) {
                div[i] = div[i] / ((Scalar) other).getValue();
            }
            return new Vector(div);
        }
        else return super.div(other);
    }
}
