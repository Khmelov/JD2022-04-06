//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package by.it.marchenko.jd01_04;

public class Helper {
    public Helper() {
    }

    static double findMin(double[] inputArray) {
        double min = Double.MAX_VALUE;
        for (double element : inputArray) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    static double findMax(double[] inputArray) {
        double max = Double.MIN_VALUE;
        for (double element : inputArray) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    static void sort(double[] inputArray) {
        int lastIndex = inputArray.length - 1;

        boolean swapPerformed;
        do {
            swapPerformed = false;
            for (int i = 0; i < lastIndex; ++i) {
                if (inputArray[i] > inputArray[i + 1]) {
                    double buffer = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = buffer;
                    swapPerformed = true;
                }
            }
            --lastIndex;
        } while (swapPerformed);

    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] matrixResult = new double[matrixLeft.length][matrixRight[0].length];

        for (int i = 0; i < matrixLeft.length; ++i) {
            for (int j = 0; j < matrixRight[0].length; ++j) {
                for (int iterator = 0; iterator < matrixRight.length; ++iterator) {
                    matrixResult[i][j] += matrixLeft[i][iterator] * matrixRight[iterator][j];
                }
            }
        }

        return matrixResult;
    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] vectorResult = new double[matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int iterator = 0; iterator < vector.length; ++iterator) {
                vectorResult[i] += matrix[i][iterator] * vector[iterator];
            }
        }

        return vectorResult;
    }
}