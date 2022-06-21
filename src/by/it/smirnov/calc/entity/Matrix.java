package by.it.smirnov.calc.entity;

import by.it.smirnov.calc.exception.CalcException;

import java.util.Arrays;

public class Matrix extends Var {

    private final double[][] values;

    Matrix(double[][] values) {
        this.values = values;
        for (int i = 0; i < values.length; i++) {
            this.values[i] = Arrays.copyOf(values[i],values[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this.values = matrix.values;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("\\s", "").replaceAll("\\{\\{", "").replaceAll("}}", "");
        String[] array = strMatrix.split("},\\{");
        String[][] multiArray = new String[array.length][];
        double[][] toDouble = new double[array.length][];
        for (int i = 0; i < multiArray.length; i++) {
            multiArray[i] = array[i].split(",");
            double[] buffer = new double[multiArray[i].length];
            for (int j = 0; j < multiArray[i].length; j++) {
                buffer[j] = Double.parseDouble(multiArray[i][j]);
            }
            toDouble[i] = buffer;
        }
        this.values = toDouble;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String newdelim = "";
        for (int i = 0; i < values.length; i++) {
            sb.append(newdelim).append("{");
            String delimiter = "";
            for (int j = 0; j < values[i].length; j++) {
                sb.append(delimiter).append(values[i][j]);
                delimiter = ",";
                }
            newdelim = "},";
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] add = new double[this.values.length][];
            for (int i = 0; i < add.length; i++) {
                add[i] = Arrays.copyOf(values[i], values[i].length);
                for (int j = 0; j < add[i].length; j++) {
                    add[i][j] = add[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(add);
        }
        else if (other instanceof Matrix) {
            double[][] add = new double[this.values.length][];
            for (int i = 0; i < add.length; i++) {
                add[i] = Arrays.copyOf(values[i], values[i].length);
                for (int j = 0; j < add[i].length; j++) {
                    add[i][j] = add[i][j] + ((Matrix) other).values[i][j];
                }
            }
            return new Matrix(add);
        }
        else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {

        if (other instanceof Scalar) {
            double[][] sub = new double[this.values.length][];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = Arrays.copyOf(values[i], values[i].length);
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j] = sub[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(sub);
        }
        else if (other instanceof Matrix) {
            double[][] sub = new double[this.values.length][];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = Arrays.copyOf(values[i], values[i].length);
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j] = sub[i][j] - ((Matrix) other).values[i][j];
                }
            }
            return new Matrix(sub);
        }
        else return super.add(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] mul = new double[this.values.length][];
            for (int i = 0; i < mul.length; i++) {
                mul[i] = Arrays.copyOf(values[i], values[i].length);
                for (int j = 0; j < mul[i].length; j++) {
                    mul[i][j] = mul[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul);
        }
        else if (other instanceof Vector) {
            int vectorLength = ((Vector) other).getValues().length;
            double[] result = new double[vectorLength];
            for (int i = 0; i < this.values.length; i++) {
                for (int j = 0; j < vectorLength; j++) {
                    if(j> this.values.length) break;
                    result[i] = result[i] + this.values[i][j] * ((Vector) other).getValues()[j];
                }
            }
            return new Vector(result);
        }
        else if (other instanceof Matrix) {
            double[][] result = new double[this.values.length][((Matrix) other).values[0].length];
            for (int i = 0; i < this.values.length; i++) {
                for (int j = 0; j < ((Matrix) other).values[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).values.length; k++) {
                        result[i][j] = result[i][j] + this.values[i][k] * ((Matrix) other).values[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        else return super.mul(other);
    }

}

