package by.it.eivanova.jd01_09;

import java.util.Arrays;

public class Matrix extends Var {

    double[][] values;


    public Matrix(double[][] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Matrix(Matrix matrix){
        this.values = matrix.values;
    }


    public Matrix(String strMatrix){
        String[] strRow = strMatrix.split("},");
        values= new double[strRow.length][];
        for (int i = 0, strRowLength = strRow.length; i < strRowLength; i++) {
            String row = strRow[i];
            row = row.replace("{", "").replace(" ", "").replace("}", "");


            String[] strings = row.split(",");
            values[i] = new double[strings.length];
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = Double.parseDouble(strings[j]);
            }
        }
    }

    //сложение
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[this.values.length][this.values[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.values[i][j] + scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix otherMatrix) {
            if (this.values.length == otherMatrix.values.length && this.values[0].length == otherMatrix.values[0].length) {
                double[][] result = new double[this.values.length][this.values[0].length];
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[0].length; j++) {
                        result[i][j] = this.values[i][j] + otherMatrix.values[i][j];
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



    //вычитание
                @Override
                public Var sub (Var other){
                    if (other instanceof Scalar scalar) {
                        double[][] result = new double[this.values.length][this.values[0].length];
                        for (int i = 0; i < result.length; i++) {
                            for (int j = 0; j < result[0].length; j++) {
                                result[i][j] = this.values[i][j] - scalar.getValue();
                            }
                        }
                        return new Matrix(result);
                    } else if (other instanceof Matrix otherMatrix) {
                        if (this.values.length == otherMatrix.values.length && this.values[0].length == otherMatrix.values[0].length) {
                            double[][] result = new double[this.values.length][this.values[0].length];
                            for (int i = 0; i < result.length; i++) {
                                for (int j = 0; j < result[0].length; j++) {
                                    result[i][j] = this.values[i][j] - otherMatrix.values[i][j];
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

    //умножение
                @Override
                public Var mul (Var other){
                    if (other instanceof Scalar scalar) {
                        double[][] result = new double[this.values.length][this.values[0].length];
                        for (int i = 0; i < result.length; i++) {
                            for (int j = 0; j < result[0].length; j++) {
                                result[i][j] = this.values[i][j] * scalar.getValue();
                            }
                        }
                        return new Matrix(result);

                    } else if (other instanceof Vector vector) {
                        double[] result = new double[this.values.length];
                        for (int i = 0; i < result.length; i++) {
                            for (int j = 0; j < result.length; j++) {
                                result[i] = result[i] + this.values[i][j] * vector.getValue()[j];
                            }
                        }

                       return new Vector(result);
                    }

                    else {
                        Matrix otherMatrix = (Matrix) other;
                        double[][] result = new double[this.values.length][otherMatrix.values[0].length];
                        for (int i = 0; i < result.length; i++) {
                            for (int j = 0; j < result[0].length; j++) {
                                for (int k = 0; k < otherMatrix.values.length; k++) {
                                    result[i][j] = result[i][j] + this.values[i][k] * otherMatrix.values[k][j];
                                }
                            }

                        }
                        return new Matrix(result);
                    }

                }

                //деление
                @Override
                public Var div (Var other){
                    return super.div(other);
                }

                @Override
                public String toString () {
                    String stringArrays = Arrays.deepToString(values);
                    stringArrays = stringArrays.replaceAll("[\\[]", "{");
                    stringArrays = stringArrays.replaceAll("[\\]]", "}");
                    return stringArrays;
                }
            }