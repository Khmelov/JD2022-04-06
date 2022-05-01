package by.it.ragach.jd01_08;

class Matrix extends Var {
    private final double[][] value;


    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix (Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix (String strMatrix){
        this.value = changeMatrixtoString(strMatrix);

    }

    private double[][] changeMatrixtoString(String strMatrix) {



        return new double[0][];
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
