package by.it.arsenihlaz.jd01_03;

import java.util.Arrays;

public class Helper {

    static double findMin(double[] array) {
        double min = 10000;
        for (double row : array) {
            if (row < min) {
                min = row;
            }
        }
        System.out.println("Minimum " + "= " + min);
        return min;
    }

    static double findMax(double[] array) {
        double max = 0;
        for (double row : array) {
            if (row > max) {
                max = row;
            }
        }
        System.out.println("Maximum " + "= " + max);
        return max;
    }

    static void sort(double[] array) {
        Arrays.sort(array);
        System.out.println("Sort array:");
        for (double v : array) {
            System.out.print(v + " ");
        }
    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] matrixOnVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                matrixOnVector[i] = matrixOnVector[i] + matrix[i][j] * vector[j];
            }
        }
        System.out.println();
        System.out.println("Matrix: ");
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("Vector: ");
        System.out.println(Arrays.toString(vector));
        System.out.println("Matrix * Vector: ");
        System.out.println(Arrays.toString(matrixOnVector));
        return matrixOnVector;
    }
    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] matrixOnMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    matrixOnMatrix[i][j] = matrixOnMatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        System.out.println();
        System.out.println("MatrixLeft: ");
        System.out.println(Arrays.deepToString(matrixLeft));
        System.out.println("MatrixRight: ");
        System.out.println(Arrays.deepToString(matrixRight));
        System.out.println("MatrixLeft * MatrixRight: ");
        System.out.println(Arrays.deepToString(matrixOnMatrix));
        return matrixOnMatrix;
    }

}
//for (int i = 0; i < matrix.length; i++) {
//        for (int j = 0; j < matrix.length; j++) {
//        Random random = new Random();
//        matrix[i][j] = random.nextInt(0, 5);
//        }
//        }