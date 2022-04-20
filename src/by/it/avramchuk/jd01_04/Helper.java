package by.it.avramchuk.jd01_04;

public class Helper {
    static double findMin(double[] array) {
        double min = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    static double findMax(double[] array){
        double max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    static void sort(double[] array) {
        int last = array.length - 1;
        boolean swap;
       do {
           swap = false;
           for (int i = 0; i < last; i++) {
               if (array[i]>array[i+1]){
                   double buffer = array[i];
                   array[i]=array[i+1];
                   array[i+1] = buffer;
                   swap = true;
               }
           }
           last--;
       } while(swap);
    }

    static double[] multiply(double[][]matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight){
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j]= result[i][j]+ matrixLeft[i][k]*matrixRight[k][j];
                }
            }

        }
        return result;
    }
}
