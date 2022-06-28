package by.it.ragach.calc;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value.clone();
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }


    public Vector(String strVector) {
        this.value = changeStringToDoubleArray(strVector);


    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + scalar.getValue();
            }
            return new Vector(result);
        } else {
            if (other instanceof Vector vector) {
                if (this.value.length!=vector.value.length){
                    throw new CalcException("incorrect size for %s+%s", this,vector);
                }
                double[] result = value.clone();
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i] + vector.value[i];
                }
                return new Vector(result);

            } else {
                return super.add(other);
            }
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - scalar.getValue();

            }
            return new Vector(result);

        } else {
            if (other instanceof Vector vector) {
                double[] result = value.clone();
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i] - vector.value[i];

                }
                return new Vector(result);
            } else {
                return super.add(other);
            }
        }
    }


    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * scalar.getValue();

            }
            return new Vector(result);

        } else {
            if (other instanceof Vector vector) {
                double[] v1 = value.clone();
                double result = 0;
                for (int i = 0; i < v1.length; i++) {
                    result = result + v1[i] * vector.value[i];

                }
                return new Scalar(result);

            } else {
                return super.mul(other);
            }
        }

    }


    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar scalar){
            double[]result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i]/scalar.getValue();

            }return new Vector(result);
        }else {
            if (other instanceof Vector vector);
        }
        return super.div(other);
    }

    public double[] getValue() {
        return this.value.clone();
    }

    private double[] changeStringToDoubleArray(String strVector) {
        String change = strVector.replaceAll("[{}]", "");
        String[] array = change.trim().split(",");
        double[] array2 = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i] = Double.parseDouble(array[i]);
        }
        return array2;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            str.append(delimiter).append(element);
            delimiter = ", ";
        }
        str.append("}");
        return str.toString();

    }

}
