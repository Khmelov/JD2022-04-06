package by.it.kameisha.jd01_08;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        double[][] array = new double[value.length][];
        for (int i = 0; i < value.length; i++) {
            array[i] = value[i].clone();
        }
        this.value = array;
    }

    public Matrix(Matrix matrix) {
        double[][] newMatrix = new double[matrix.value.length][];
        for (int i = 0; i < matrix.value.length; i++) {
            newMatrix[i] = matrix.value[i].clone();
        }
        this.value = newMatrix;
    }

    public Matrix(String strMatrix) {
        String[] strings = strMatrix.split("},");
        double[][] array = new double[strings.length][strings.length];
        for (int i = 0; i < strings.length; i++) {
            String arrayString = strings[i];
            arrayString = arrayString.replace("{", "");
            arrayString = arrayString.replace("}", "");
            String[] tempString = arrayString.split(",");
            for (int j = 0; j < tempString.length; j++) {
                array[i][j] = Double.parseDouble(tempString[j]);
            }
        }
        this.value = array;
    }

    @Override
    public String toString() {
        StringBuilder strValue = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            String splitter = "";
            strValue.append("{");
            for (int j = 0; j < value[i].length; j++) {
                strValue.append(splitter).append(value[i][j]);
                splitter = ", ";
            }
            strValue.append("}");
            if (i == value.length - 1) {
                splitter = "";
            }
            strValue.append(splitter);
        }
        strValue.append("}");
        return strValue.toString();
    }

    private boolean checkMatrix(Matrix matrix) {
        boolean result = true;
        for (int i = 0; i < matrix.value.length; i++) {
            if (matrix.value[0].length != matrix.value[i].length) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar && checkMatrix(new Matrix(value))) {
            double[][] newMatrix = new double[value.length][];
            for (int i = 0; i < value.length; i++) {
                newMatrix[i] = value[i].clone();
                for (int j = 0; j < value[i].length; j++) {
                    newMatrix[i][j] = newMatrix[i][j] + scalar.getValue();
                }
            }
            return new Matrix(newMatrix);
        } else if (other instanceof Matrix matrix && checkMatrix(new Matrix(value)) &&
                checkMatrix(matrix) && matrix.value.length == value.length) {
            double[][] newMatrix = new double[value.length][];
            for (int i = 0; i < value.length; i++) {
                newMatrix[i] = value[i].clone();
                for (int j = 0; j < value[i].length; j++) {
                    newMatrix[i][j] = newMatrix[i][j] + matrix.value[i][j];
                }
            }
            return new Matrix(newMatrix);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar && checkMatrix(new Matrix(value))) {
            double[][] newMatrix = new double[value.length][];
            for (int i = 0; i < value.length; i++) {
                newMatrix[i] = value[i].clone();
                for (int j = 0; j < value[i].length; j++) {
                    newMatrix[i][j] = newMatrix[i][j] - scalar.getValue();
                }
            }
            return new Matrix(newMatrix);
        } else if (other instanceof Matrix matrix && checkMatrix(new Matrix(value)) &&
                checkMatrix(matrix) && matrix.value.length == value.length) {
            double[][] newMatrix = new double[value.length][];
            for (int i = 0; i < value.length; i++) {
                newMatrix[i] = value[i].clone();
                for (int j = 0; j < value[i].length; j++) {
                    newMatrix[i][j] = newMatrix[i][j] - matrix.value[i][j];
                }
            }
            return new Matrix(newMatrix);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar && checkMatrix(new Matrix(value))) {
            double[][] newMatrix = new double[value.length][];
            for (int i = 0; i < value.length; i++) {
                newMatrix[i] = value[i].clone();
                for (int j = 0; j < value[i].length; j++) {
                    newMatrix[i][j] = newMatrix[i][j] * scalar.getValue();
                }
            }
            return new Matrix(newMatrix);
        } else if (other instanceof Vector vector && checkMatrix(new Matrix(value))) {
            double[] newVector = new double[vector.getValue().length];
            for (int i = 0; i < vector.getValue().length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    newVector[i] = newVector[i] + value[i][j] * vector.getValue()[j];
                }
            }
            return new Vector(newVector);
        } else if ((other instanceof Matrix matrix && checkMatrix(new Matrix(value)) &&
                checkMatrix(matrix) && matrix.value[0].length == value.length)) {
            double[][] newMatrix = new double[value.length][matrix.value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < matrix.value[0].length; j++) {
                    for (int k = 0; k < matrix.value.length; k++) {
                        newMatrix[i][j] = newMatrix[i][j] + value[i][k] * matrix.value[k][j];
                    }
                }
            }
            return new Matrix(newMatrix);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar && checkMatrix(new Matrix(value))) {
            double[][] newMatrix = new double[value.length][];
            for (int i = 0; i < value.length; i++) {
                newMatrix[i] = value[i].clone();
                for (int j = 0; j < value[i].length; j++) {
                    newMatrix[i][j] = newMatrix[i][j] / scalar.getValue();
                }
            }
            return new Matrix(newMatrix);
        } else {
            return super.div(other);
        }
    }
}
