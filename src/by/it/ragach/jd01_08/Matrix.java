package by.it.ragach.jd01_08;

class Matrix extends Var {
    private final double[][] value;


    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix (Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix (String strMatrix) {

        String[]strRow = strMatrix.split("},");
        value = new double[strRow.length][];
        for (int i = 0; i < strRow.length; i++) {
            String row =strRow[i];
            row = row.replace("{","").
                    replace(" ","").
                        replace("}","");
            String [] strings = row.split(",");
            value[i] = new double[strings.length];
            for (int j = 0; j < value.length; j++) {
                value[i][j] = Double.parseDouble(strings[j]);
                
            }

        }

    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[][] result = new double[value.length][];
            for (int i = 0; i < result.length; i++) {
                result[i] = value[i].clone();
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = result[i][j] + otherScalar.getValue();

                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix otherMatrix) {
            if (value.length == otherMatrix.value.length) {
                double[][] result = new double[value.length][];
                for (int i = 0; i < result.length; i++) {
                    result[i] = value[i].clone();
                    for (int j = 0; j < result.length; j++) {
                        result[i][j] = result[i][j] + otherMatrix.value[i][j];

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
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        String start = "";
        for (int i = 0; i < value.length; i++) {
            str.append(start).append("{");
            String delimiter = "";
            for (int j = 0; j < value.length; j++) {
                str.append(delimiter).append(value[i][j]);
                delimiter = ", ";

            }
            start="}, ";
        }
            str.append("}}");
            return str.toString();


        }
    }
