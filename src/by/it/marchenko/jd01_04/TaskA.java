package by.it.marchenko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    private static final String INPUT_ARRAY_NAME = "V";
    private static final int INPUT_ARRAY_COLUMN = 5;
    private static final String OUTPUT_ARRAY_NAME = "V";
    private static final int OUTPUT_ARRAY_COLUMN = 4;


    public static void main(String[] args) {
        printMulTable();
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        buildOneDimArray(line);
    }

    private static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line) {
        double[] inputArray = InOut.getArray(line);
        InOut.printArray(inputArray, INPUT_ARRAY_NAME, INPUT_ARRAY_COLUMN);
        double firstElement = inputArray[0];
        double lastElement = inputArray[inputArray.length - 1];
        Helper.sort(inputArray);
        InOut.printArray(inputArray, OUTPUT_ARRAY_NAME, OUTPUT_ARRAY_COLUMN);
        int indexFirst = Arrays.binarySearch(inputArray, firstElement);
        System.out.println("Index of first element=" + indexFirst);
        int indexLast = Arrays.binarySearch(inputArray, lastElement);
        System.out.println("Index of last element=" + indexLast);
    }
}
