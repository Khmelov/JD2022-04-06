package by.it.machuga.jd01_05;

import java.util.Random;

public class TaskC {
    public static void main(String[] args) {
        task6();
    }

    private static void task6() {
        double start = 5.33;
        double stop = 9;
        Random random = new Random();
        int rand = random.nextInt(20, 40 + 1);
        double[] array = new double[rand];
        double step = (stop - start) / rand;
        int countElement = 0;
        double x = start;
        for (int i = 0; i < array.length; i++, x += step) {
            double z = Math.cbrt(Math.pow(x, 2) + 4.5);
            array[i] = z;
            if (z > 3.5) {
                countElement++;
            }
        }
        printArray(array, "A", 5);
        double[] arr = new double[countElement];
        int k = 0;
        double product = 1.0;
        for (double element : array) {
            if (element > 3.5) {
                arr[k] = element;
                product *= arr[k];
                k++;
            }
        }
        printArray(arr, "B", 5);
        double geometricMean = Math.pow(product, 1.0 / arr.length);
        System.out.printf(" Geometric mean = %20.18f", geometricMean);
    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.5f ", name, i, array[i]);
            if (array.length - 1 == i || (i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
