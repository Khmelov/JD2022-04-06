package by.it.edeborg.jd01_09;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value.clone();
    }

    public Matrix(by.it.edeborg.jd01_09.Matrix matrix) {
        this.value = matrix.value.clone();
    }
    //        public Matrix(String matrix) {
//        Pattern pattern = Pattern.compile("},[ ]?\\{");
//        Matcher matcher = pattern.matcher(matrix);
//        int cols = 0;
//        while (matcher.find()) {
//            cols += 1;
//        }
//        cols += 1;
//        String editedStr = matrix.replaceAll("},[ ]?\\{", " ").replaceAll("[{}]", "").replaceAll(",[ ]?", ",");
//        String[] arrayOfRows = editedStr.split(" ");
//        int rows = arrayOfRows[0].replaceAll(",", " ").split(" ").length;
//        this.value = new double[cols][rows];
//        for (int i = 0; i < this.value.length; i++) {
//            String[] row = arrayOfRows[i].replaceAll(",", " ").split(" ");
//            for (int j = 0; j < rows; j++) {
//                this.value[i][j] = Double.parseDouble(row[j]);
//            }
//        }
//    }
    public Matrix(String strMatrix) {
        Pattern pattern1 = Pattern.compile(Patterns.VECTOR);
        Matcher matcher1 = pattern1.matcher(strMatrix);
        int lines = 0;
        while (matcher1.find()) {
            lines++;
        }
        String strMatrixNew = strMatrix.replaceAll("[{}]", "");
        String[] arrayStrMatrix = strMatrixNew.split(",");
        int columns = arrayStrMatrix.length / lines;
        this.value = new double[lines][columns];
        int i = 0;
        for (int j = 0; j < lines; j++) {
            for (int k = 0; k < columns; k++) {
                value[j][k] = Double.parseDouble(arrayStrMatrix[i]);
                i++;
            }
        }
    }
    // {{1,1},{1,1},{1,1}}*{{2,2,2},{2,2,2}}
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] + scalar.getValue();
                }
            }
            return new by.it.edeborg.jd01_09.Matrix(result);
        } else if (other instanceof by.it.edeborg.jd01_09.Matrix othermatrix) {
            if (this.value.length == othermatrix.value.length && this.value[0].length == othermatrix.value[0].length) {
                double[][] result = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[0].length; j++) {
                        result[i][j] = this.value[i][j] + othermatrix.value[i][j];
                    }
                }
                return new by.it.edeborg.jd01_09.Matrix(result);
            }
        } else {
            return super.add(other);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j] - scalar.getValue();
                }
            }
            return new by.it.edeborg.jd01_09.Matrix(result);
        } else if (other instanceof by.it.edeborg.jd01_09.Matrix othermatrix) {
            if (this.value.length == othermatrix.value.length && this.value[0].length == othermatrix.getValue()[0].length) {
                double[][] result = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[0].length; j++) {
                        result[i][j] = this.value[i][j] - othermatrix.getValue()[i][j];
                    }
                }
                return new by.it.edeborg.jd01_09.Matrix(result);
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
            return new by.it.edeborg.jd01_09.Matrix(result);
        } else if (other instanceof Vector vector) {
            double[] resultVector = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < vector.getValue().length; j++) {
                    resultVector[i] = resultVector[i] + this.value[i][j] * vector.getValue()[j];
                }
            }
            return new Vector(resultVector);
        } else if (other instanceof by.it.edeborg.jd01_09.Matrix othermatrix) {
            double[][] resultmatrix = new double[this.value.length][othermatrix.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < othermatrix.value[0].length; j++) {
                    for (int k = 0; k < othermatrix.value.length; k++) {
                        resultmatrix[i][j] = resultmatrix[i][j] + this.value[i][k] * othermatrix.value[k][j];
                    }
                }
            }
            return new by.it.edeborg.jd01_09.Matrix(resultmatrix);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        String stringArrays = Arrays.deepToString(value);
        stringArrays = stringArrays.replaceAll("[\\[]", "{");
        stringArrays = stringArrays.replaceAll("[\\]]", "}");
        return stringArrays;
    }

    public double[][] getValue() {
        return value;
    }
}