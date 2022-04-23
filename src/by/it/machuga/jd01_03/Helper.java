package by.it.machuga.jd01_03;

public class Helper {
    static double findMin(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    static double findMax(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    static void sort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] =temp;
                }
            }
        }
    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] resultMatrix = new double[matrix.length];
        if (matrix[0].length != vector.length) {
            System.out.println("Matrices cannot be multiplied!");
        } else {
            for (int i = 0; i < resultMatrix.length; i++) {
                double sum = 0.0;
                for (int j = 0; j < matrix[i].length; j++) {
                    sum += matrix[i][j] * vector[j];
                }
                resultMatrix[i] = sum;
            }
        }
        return resultMatrix;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];
        if (matrixLeft[0].length != matrixRight.length) {
            System.out.println("Matrices cannot be multiplied!");
        } else {
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    double sum = 0.0;
                    for (int k = 0; k < matrixLeft[i].length; k++) {
                        sum += matrixLeft[i][k] * matrixRight[k][j];
                    }
                    resultMatrix[i][j] = sum;
                }
            }
        }
        return resultMatrix;
    }
}
