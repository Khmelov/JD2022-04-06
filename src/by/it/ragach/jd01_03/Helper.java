package by.it.ragach.jd01_03;

public class Helper {


    static double findMin(double[] array) {
        double min = array[0];
        for (double element : array)
            if (min > element) {
                min = element;

                System.out.println(min);
            }
        return min;
    }

    public static double findMax(double[] array) {
        double max = array[0];
        for (double element : array) {
            if (max < element) {
                max = element;

                System.out.println(max);
            }

        }
        return max;
    }



    public static double[] sort(double[] array) {
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
            last--;
        } while (swap);

        return array;
    }


    public static double[] multiply(double[ ][ ] matrix, double[ ] vector) {

        int i = matrix.length;
        int j = matrix[0].length;


        double[] result = new double[i];

        for (i = 0; i < matrix.length; i++) {
            double sum = 0;
            for ( j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j]* vector[j];
            }
            result[i] = sum;
    }
        return result;
    }

    static double[ ][ ] multiply(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){

        int i = matrixLeft.length;
        int j = matrixRight[0].length;
        int k = matrixRight.length;


        double[][] result = new double [i][j];

        for (i = 0; i < matrixLeft.length; i++) {
            for (j = 0; j < matrixRight[i].length; j++) {
                for (int l = 0; l < matrixRight.length; l++) {
                    result[i][j]+= matrixLeft[i][l]*matrixRight[l][j];

                }

            }
            
        }

        return result;
    }




}
























