package by.it.kudelko.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (firstElement == array[i]) {
                System.out.printf("Index of first element=%-3d", i);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (lastElement == array[i]) {
                System.out.printf("Index of last element=%-3d", i);
            }
        }
    }

    static void mergeSort(double[] array) {
        getPart(array);
    }

    private static double[] getPart(double[] array) {
        double[] arrayLeft = new double[array.length / 2];
        System.arraycopy(array, 0, arrayLeft, 0, array.length / 2);
        double[] arrayRight = new double[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, arrayRight, 0, array.length - array.length / 2);
        arrayLeft = getPart(arrayLeft);
        arrayRight = getPart(arrayRight);
        return arrayLeft;
    }


}
