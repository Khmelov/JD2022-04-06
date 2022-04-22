package by.it.penkrat.jd01_03;

import java.util.Arrays;
import java.util.Random;

public class Helper {

    static double findMax(double[] array) {
        if (0 == array.length) {
            return Double.MAX_VALUE;
        } else {
            double max = array[0];
            for (double arr : array) {
                if (max < arr) max = arr;
            }
            System.out.println(max);
            return max;
        }
    }

    static double findMin(double[] array) {
        if (0 == array.length) {
            return Double.MIN_VALUE;
        } else {
            double min = array[0];
            for (double element : array) {
                if (min > element) {
                    min = element;
                }
            }
            System.out.println(min);
            return min;
        }
    }

    static void sort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[j + 1] < array[i]) {
                    double temp = array[i];
                    array[i] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


//    static double[] multiply(double[][] matrix, double[] vector) {
//        double[] z = new double[matrix.length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < vector.length; j++) {
//
//                z[i] = z[i] + matrix[i][j] * vector[j];
//            }
//        }
//        return z;
//    }

    static double[] multiply(double[][] matrix, double[] vector) {

        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {

                z[i] = z[i] + matrix[i][j] * vector[j];
            }
            System.out.println(z[i] + " ");
        }

        return z;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {


        double[][] mat = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mat[i][j] = mat[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
       return mat;
    }
}
