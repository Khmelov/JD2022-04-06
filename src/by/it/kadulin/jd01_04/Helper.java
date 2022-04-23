package by.it.kadulin.jd01_04;

public class Helper {
    static double findMin(double[] array) {
        double min = 0;
        if (array.length == 1) {
            min = array[0];
        }
        else {
            min = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }
        }
        return min;
    }

    static double findMax(double[] array) {
        double max = 0;
        if (array.length == 1) {
            max = array[0];
        }
        else {
            max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
        }
        return max;
    }

    static void sort(double[] array) {
        boolean swap = true;
        int deadLine = array.length - 1;
        while (swap) {

            swap = false;

            for (int i = 0; i < deadLine; i++) {
                if (array[i] > array[i + 1]) {
                    swap = true;
                    double max = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = max;
                }

            }
            deadLine--;
        }
        InOut.printArray(array);
    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] resultArray = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                resultArray[i] = resultArray[i] + matrix[i][j] * vector[j];
            }
        }
        return resultArray;
//        double[] z = new double[matrix.length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < vector.length; j++) {
//                z[i] = z[i] + matrix[i][j] * vector[j];
//            }
//        }
//        return z;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[i].length; j++) {
                for (int k = 0; k < matrixLeft[0].length; k++) {
                    resultMatrix[i][j] = resultMatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j]; //k нужно, чтобы перейти к след элемнту в изначальных матрицах

                }
            }
        }
        return resultMatrix;
    }

}
