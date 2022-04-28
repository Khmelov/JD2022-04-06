package by.it.kameisha.jd01_07;

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
        double[][] array = new double[matrix.value.length][];
        for (int i = 0; i < matrix.value.length; i++) {
            array[i] = matrix.value[i].clone();
        }
        this.value = array;
    }
}
