package by.it.kameisha.jd01_08;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value.clone();
    }

    public Vector(Vector vector) {
        this.value = vector.value.clone();
    }

    public double[] getValue() {
        return value;
    }

    public Vector(String strVector) {
        strVector = strVector.replace("{", "");
        strVector = strVector.replace("}", "");
        String[] strings = strVector.split(",");
        double[] value = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            value[i] = Double.parseDouble(strings[i]);
        }
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder strValue = new StringBuilder("{");
        String splitter = "";
        for (double element : value) {
            strValue.append(splitter).append(element);
            splitter = ", ";
        }
        strValue.append("}");
        return strValue.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector && value.length == ((Vector) other).value.length) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + vector.value[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector && value.length == ((Vector) other).value.length) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - vector.value[i];
            }
            return new Vector(result);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector && value.length == ((Vector) other).value.length) {
            double[] result = value.clone();
            double scalarResult = 0;
            for (int i = 0; i < result.length; i++) {
                scalarResult = scalarResult + result[i] * vector.value[i];
            }
            return new Scalar(scalarResult);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / scalar.getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }
}
