package by.it.kudelko.jd01_04;


public class Helper {

    static double findMin(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println(min);
        System.out.println();
        return min;
    }

    static double findMax(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println(max);
        System.out.println();
        return max;
    }

    static void sort(double[] array) {
        boolean swap;
        double elem = array.length - 1;
        do {
            swap = false;
            for (int i = 0; i < elem; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swap = true;
                }
            }
            elem--;
        } while (swap);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static double[ ] multiply(double[ ][ ] matrix, double[ ] vector){
        double[] array3 = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                array3[i] = array3[i] + matrix[i][j] * vector[j];
            }
        }
        return array3;
    }

    static double[ ][ ] multiply(double[ ][ ] matrixLeft, double[ ][ ] matrixRight) {
        double[][] array5 = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    array5[i][j] = array5[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return array5;
    }
}
