package by.it.kudelko.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        printMulTable();
        buildOneDimArray(line);
    }



    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }
    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double firstElement = array [0];
        double lastElement = array[array.length-1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (firstElement == array[i]) {
                System.out.printf("Index of first element=%-3d", i);
            }
        }
            for (int i = 0; i < array.length; i++) {
                if (lastElement == array[i]){
                    System.out.printf("Index of last element=%-3d", i);
                }
        }
    }
}
