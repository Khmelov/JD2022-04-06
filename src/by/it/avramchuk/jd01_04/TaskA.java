package by.it.avramchuk.jd01_04;

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
                System.out.printf("%d*%d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length-1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);

        int indexFirst = Arrays.binarySearch(array, first);
        int indexLast = Arrays.binarySearch(array, last);

        System.out.println("Index of first element="+indexFirst);
        System.out.println("Index of last element="+indexLast);

    }
}
