package by.it.kameisha.jd01_03;

public class Helper {
    static double findMin(double[] array) {
        double minElement = Double.MAX_VALUE;
        for (double element : array) {
            if (minElement > element) {
                minElement = element;
            }
        }
        return minElement;
    }

    static double findMax(double[] array) {
        double maxElement = Double.MIN_VALUE;
        for (double element : array) {
            if (maxElement < element) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    static void sort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            double minElement = array[i];
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (minElement > array[j]) {
                    minElement = array[j];
                    minElementIndex = j;
                }
            }
            if (i != minElementIndex) {
                double temporary = array[i];
                array[i] = array[minElementIndex];
                array[minElementIndex] = temporary;
            }
        }
    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] array = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                array[i] = array[i] + matrix[i][j] * vector[j];
            }
        }
        return array;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] array = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    array[i][j] = array[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }

        }
        return array;
    }
}
