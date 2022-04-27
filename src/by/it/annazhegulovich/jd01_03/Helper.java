package by.it.annazhegulovich.jd01_03;

class Helper {
    public static double findMin(double[] array) {

        if (0 == array.length) {
            return Double.MIN_VALUE;
        } else {
            double min = array[0];
            for (double element : array) {
                if (min > element) {
                    min = element;
                }
            }
            return min;
        }

    }

    static double findMax(double[] array) {
        if (0 == array.length) {
            return Double.MAX_VALUE;
        } else {
            double max = array[0];
            for (double element : array) {
                if (max < element) {
                    max = element;
                }
            }
            return max;
        }

    }

    static void sort(double[] array) {
        boolean swap;
        double last = array.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swap = true;
                }
            }
        } while (swap);
        printMas(array);
    }

    private static void printMas(double[] arraynew) {
        for (double array : arraynew) {
            System.out.print(array + " ");
        }
        System.out.println();
    }

    static double[ ] multiply(double[ ][ ] matrix, double[ ] vector){
        double[] result=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result [i]=result[i]+matrix[i][j]*vector[j];
            }
        }
        return result;
    }

    static double[ ][ ] multiply(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double [][] result=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j]=result[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return result;
    }
}
