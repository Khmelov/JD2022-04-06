package by.it.penkrat.jd01_07;

class Matrix extends Var{

    double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }
    Matrix(Matrix matrix){
        this.value= matrix.value;
    }
    Matrix(String strMatrix){

        String[] newStr = strMatrix.split("},");
        for (int i =0; i< newStr.length; i++){
            newStr[i] = newStr[i].replaceAll("[{}]+", "");
            System.out.println(newStr[i] + " ");
        }
        String[][] doubleString = new String[newStr.length][];
        }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter=", ";
                }
            delimiter ="}, {";
        }
        sb.append("}}");
        return sb.toString();
    }
}
