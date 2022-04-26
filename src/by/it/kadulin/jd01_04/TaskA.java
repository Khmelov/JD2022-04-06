package by.it.kadulin.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        buildOneDimArray(sc.nextLine());
    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        System.out.println();
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        System.out.println();
        System.out.println("Index of first element=" + Arrays.binarySearch(array, firstElement));
        System.out.println("Index of last element=" + Arrays.binarySearch(array, lastElement));
    }
}
