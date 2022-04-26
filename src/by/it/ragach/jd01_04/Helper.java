package by.it.ragach.jd01_04;

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

        System.out.print(array);

        return array;
    }
}
























