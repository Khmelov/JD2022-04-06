package by.it.kameisha.jd01_08;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[ ][ ] value){
        double[][] array = new double[value.length][];
        for (int i = 0; i < value.length; i++) {
            array[i] = value[i].clone();
        }
        this.value = array;
    }

    public Matrix(Matrix matrix){
        double[][] newMatrix = new double[matrix.value.length][];
        for (int i = 0; i < matrix.value.length; i++) {
            newMatrix[i] = matrix.value[i].clone();
        }
        this.value = newMatrix;
    }

    public Matrix(String strMatrix){
        String[] strings = strMatrix.split("},");
        double[][] array = new double[strings.length][strings.length];
        for (int i = 0; i < strings.length; i++) {
            String arrayString = strings[i];
            arrayString = arrayString.replace("{","");
            arrayString = arrayString.replace("}","");
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
            if(i == value.length-1){
                splitter = "";
            }
            strValue.append(splitter);
        }
        strValue.append("}");
        return strValue.toString();
    }

    @Override
    public Var add(Var other) {
        return null;
    }

    @Override
    public Var sub(Var other) {
        return null;
    }

    @Override
    public Var mul(Var other) {
        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }
}
