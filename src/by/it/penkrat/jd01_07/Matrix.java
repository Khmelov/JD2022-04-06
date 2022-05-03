package by.it.penkrat.jd01_07;

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
