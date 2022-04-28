package by.it.smirnov.jd01_07;

class Matrix extends Var {

    private final double[][] values;

    Matrix(double[][] values) {
        this.values = values;
    }

    Matrix(Matrix matrix) {
        this.values = matrix.values;
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
                delimiter = ", ";
                }
            newdelim = "}, ";
        }
        sb.append("}}");
        return sb.toString();
    }
}

