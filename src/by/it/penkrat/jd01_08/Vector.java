package by.it.penkrat.jd01_08;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value.clone();
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        String str = strVector.replaceAll("[{}\\s]+", "");
        String[] newStr = str.split(",");
        double[] value1 = new double[newStr.length];
        for (int i = 0; i < value1.length; i++) {
            value1[i] = Double.parseDouble(newStr[i]);
            this.value = value1;
        }
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar){
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector){
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + vector.value[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar){
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i]= result[i]-scalar.getValue();
            }
            return new Vector(result);
        } else if(other instanceof Vector vector){
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - vector.value[i];
            }
            return new Vector(result);

        }else{
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar scalar){
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * scalar.getValue();
            }
            return new Vector(result);
        }else if(other instanceof Vector vector){
            double[] result = value.clone();
            double mul =0;
            for (int i = 0; i < result.length; i++) {
                mul += result[i] * vector.value[i];
            }
            return new Scalar(mul);
        }else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar scalar){
            double[] result = value.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / scalar.getValue();
            }
            return new Vector(result);
        }else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
