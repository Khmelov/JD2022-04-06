package by.it.eivanova.jd01_03;

import java.util.Arrays;

public class Helper {
    private static String line;


    public static void sort(double[] array) {
        Arrays.sort(array);
    }


    public static void main(String[] args) {

    }


     static double findMax(double[ ] array){
        Arrays.sort(array);
        double max = array[array.length - 1];
        System.out.println(max);
        return max;
    }


    static double findMin(double[] array) {
        Arrays.sort(array);
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[0]) {
                min = array[i];
                return array[i];
            }
        }
        System.out.println(min);
       // return 0;
        return min;
    }


    static double[ ] multiply(double[ ][ ] matrix, double[ ] vector){
        int rows = matrix.length;
        int columns = matrix[0].length;
        double[] result = new double[rows];

        for (int row = 0; row < rows; row++) {
            double sum = 0;
            for (int column = 0; column < columns; column++) {
                sum += matrix[row][column]
                        * vector[column];
            }
            result[row] = sum;
        }
        return result;
    }



    static double[ ][ ] multiply(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){

        double[][] result = new double[matrixLeft.length][matrixRight[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(matrixLeft, matrixRight, row, col);
            }
        }

        return result;
    }

    private static double multiplyMatricesCell(double[][] matrixLeft, double[][] matrixRight, int row, int col) {
        double cell = 0;
        for (int i = 0; i < matrixRight.length; i++) {
            cell += matrixLeft[row][i] * matrixRight[i][col];
        }
        return cell;
    }

}





