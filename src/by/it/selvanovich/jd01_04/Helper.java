package by.it.selvanovich.jd01_04;


public class Helper {
    static double findMin(double[] array){
        double min = 0;
        for (double element : array) {
            if (min > element) {
                min = element;
            }
        }
        return min;
    }

    static double findMax(double[] array){
        double max = 0;
        for (double element : array) {
            if (max < element) {
                max = element;
            }
        }
        return max;
    }

    static void sort(double[] array){
        for (int sortIndex = 0; sortIndex < array.length; sortIndex++) {
            int minIndex = sortIndex;
            for (int i = sortIndex; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            double temp = array[sortIndex];
            array[sortIndex] = array[minIndex];
            array[minIndex] = temp;
        }
        InOut.printArray(array);
    }

    static double[ ] multiply(double[ ][ ] matrix, double[ ] vector){
        double[] resoult = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                resoult[i] = resoult[i] + matrix[i][j] * vector[j];
            }
        }
        InOut.printArray(resoult);
        return resoult;
    }

    static double[ ][ ] multiply(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] resoult = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int index = 0; index < matrixRight.length; index++) {
                    resoult[i][j] = resoult[i][j] + matrixLeft[i][index] * matrixRight[index][j];
                }
            }
        }
        InOut.printMatrix(resoult);
        return resoult;
    }
}
