package by.it.kadulin.jd01_09;

class Vector extends Var {

    public Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(Vector values) {
        this.values = values.values;
    }

    public Vector(String values) {
        String edited = values.replaceAll("[{} ]", "");
        String[] temp = edited.split(",");
        this.values = new double[temp.length];
        for (int i = 0; i < temp.length; i++) {
            this.values[i] = Double.parseDouble(temp[i]);
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
        }
        else if (other instanceof Vector vector) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + vector.values[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - scalar.getValue();
            }
            return new Vector(result);
        }
        else if (other instanceof Vector vector) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - vector.values[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * scalar.getValue();
            }
            return new Vector(result);
        }
        else if (other instanceof Vector vector) {
            double result = 0;
            for (int i = 0; i < vector.values.length; i++) {
                result = result + (vector.values[i] * this.values[i]);
            }
            return new Scalar(result);
        }
        return super.mul(other);
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

    private final double[] values;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < values.length; i++) {
            if (i != values.length - 1) {
                sb.append(values[i]).append(", ");
            }
            else {
                sb.append(values[i]);
            }
        }
        sb.append("}");
        return sb.toString();
    }


}
