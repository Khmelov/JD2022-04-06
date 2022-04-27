package by.it.korennaya.jd01_03;

public class Helper {
    static double findMin(double[] array) {
        if (0 == array.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = array[0];
            for (double element : array) {
                if (element < min) min = element;
            }
            return min;
        }
    }

    static double findMax(double[] array) {
        if (0 == array.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = array[0];
            for (double element : array) {
                if (element > max) max = element;
            }
            return max;
        }
    }

    public static void sort(double[] array) {
        boolean swap;
        int last = array.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (array[j] > array[j + 1]) {
                    double buffer = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = buffer;
                    swap = true;
                }
            }
            last--;
        } while (swap);
    }
}
