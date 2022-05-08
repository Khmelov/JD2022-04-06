package by.it.penkrat.jd01_08;

class Matrix extends Var {

    double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {

        String[] newStr = strMatrix.split("},");
        value = new double[newStr.length][];
        for (int i = 0; i < newStr.length; i++) {

            String row = newStr[i].replace("{", "")
                    .replace(" ", "")
                    .replace("}", "");
            String[] rows = row.split(",");
            value[i] = new double[rows.length];
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(rows[j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[value.length][];
            for (int i = 0; i < result.length; i++) {
                result[i] = value[i].clone();
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] + scalar.getValue();
                }

            }
            return new Matrix(result);
        } else if (other instanceof Matrix matrix) {
            double[][] result = new double[value.length][];
                for (int i = 0; i < result.length; i++) {
                    result[i] = value[i].clone();
                    for (int j = 0; j < result.length; j++) {
                        result[i][j] = result[i][j] + matrix.value[i][j];
                    }
                }
            return new Matrix(result);

        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[value.length][];
            for (int i = 0; i < result.length; i++) {
                result[i] = value[i].clone();
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = result[i][j] - scalar.getValue();

                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix matrix) {
            double[][] result = new double[value.length][];
                for (int i = 0; i < result.length; i++) {
                    result[i] = value[i].clone();
                    for (int j = 0; j < result[i].length; j++) {
                        result[i][j] = result[i][j] - matrix.value[i][j];
                    }
                }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar scalar){
            double[][] result = new double[value.length][];
            for (int i = 0; i < result.length; i++) {
                result[i] = value[i].clone();
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = result[i][j] * scalar.getValue();
                }
            }
            return new Matrix(result);
        }else if(other instanceof Vector vector){
            double[] sub = new double[value.length];
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub.length; j++) {
                    sub[i] = sub[i] + value[i][j] * vector.getValue()[j];
                }
            }
            return new Vector(sub);

        }else if (other instanceof Matrix matrix){
            double[][] result = new double[value.length][matrix.value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < matrix.value[0].length; j++) {
                    for (int k = 0; k < matrix.value.length; k++) {
                        result[i][j] = result[i][j] + value[i][k] * matrix.value[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[value.length][];
            for (int i = 0; i < result.length; i++) {
                result[i] = value[i].clone();
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] / scalar.getValue();
                }
            }
            return new Matrix(result);
        }else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            delimiter = "}, {";
        }
        sb.append("}}");
        return sb.toString();
    }
}
