package by.it.avramchuk.calc;

import java.util.Arrays;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value.clone();
        for (int i = 0; i < value.length; i++) {
            this.value[i] = value[i].clone();
        }
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value.clone();
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = matrix.value[i].clone();
        }
    }

    public Matrix(String strMatrix) {
        String[] mainStr = strMatrix.split("},|}\\s+,");
        String[][] res = new String[mainStr.length][];
        for (int i = 0; i < mainStr.length; i++) {
            mainStr[i] = mainStr[i].replaceAll("[^.0-9]", " ");
            mainStr[i] = mainStr[i].trim();
            res[i] = mainStr[i].split("\s+");
        }

        this.value = new double[res.length][res[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                this.value[i][j] = Double.parseDouble(res[i][j]);
            }
        }
    }

    public double[][] getValue() {
        double[][] res = this.value.clone();
        for (int i = 0; i < this.value.length; i++) {
            res[i] = this.value[i].clone();
        }
        return res;
    }

    @Override
    public String toString() {
        String str = "{";
        for (int i = 0; i < value.length; i++) {
            str = str.concat(Arrays.toString(value[i]).
                    replaceAll("\\[", "{").
                    replaceAll("]", "}"));
            if (i != value.length - 1) {
                str = str.concat(", ");
            }
        }
        str = str + "}";
        return str;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] + scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix otherMatrix) {
            if (this.value.length == otherMatrix.value.length && this.value[0].length == otherMatrix.value[0].length) {
                double[][] result = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[0].length; j++) {
                        result[i][j] = this.value[i][j] + otherMatrix.value[i][j];
                    }
                }
                return new Matrix(result);
            } else {
                return super.add(other);
            }
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] - scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix otherMatrix) {
            if (this.value.length == otherMatrix.value.length && this.value[0].length == otherMatrix.value[0].length) {
                double[][] result = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[0].length; j++) {
                        result[i][j] = this.value[i][j] - otherMatrix.value[i][j];
                    }
                }
                return new Matrix(result);
            } else {
                return super.sub(other);
            }
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] * scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector vector) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i] = result[i] + this.value[i][j] * vector.getValues()[j];
                }
            }
            return new Vector(result);
        } else {
            Matrix otherMatrix = (Matrix) other;
            double[][] result = new double[this.value.length][otherMatrix.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    for (int k = 0; k < otherMatrix.value.length; k++) {
                        result[i][j] = result[i][j] + this.value[i][k] * otherMatrix.value[k][j];
                    }
                }

            }
            return new Matrix(result);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            if (scalar.getValue() == 0) {
                return super.div(other);
            } else {
                double[][] result = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[0].length; j++) {
                        result[i][j] = this.value[i][j] / scalar.getValue();
                    }
                }
                return new Matrix(result);
            }
        }else {return super.div(other);}
    }
}
