package by.it.marchenko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    private static final String INPUT_ARRAY_NAME = "V";
    private static final int INPUT_ARRAY_COLUMN = 5;
    private static final String OUTPUT_ARRAY_NAME = "V";
    private static final int OUTPUT_ARRAY_COLUMN = 4;


    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();

        buildOneDimArray(line);
    }


    private static void buildOneDimArray(String line) {
        double[] inputArray = InOut.getArray(line);
        InOut.printArray(inputArray, INPUT_ARRAY_NAME, INPUT_ARRAY_COLUMN);
        double firstElement = inputArray[0];
        double lastElement = inputArray[inputArray.length - 1];
        mergeSort(inputArray);
        InOut.printArray(inputArray, OUTPUT_ARRAY_NAME, OUTPUT_ARRAY_COLUMN);
        int indexFirst = Arrays.binarySearch(inputArray, firstElement);
        System.out.println("Index of first element=" + indexFirst);
        int indexLast = Arrays.binarySearch(inputArray, lastElement);
        System.out.println("Index of last element=" + indexLast);
    }

    private static void mergeSort(double[] array) {
        if (array.length > 1) {
            int indexLeft = 0;
            int indexRight = array.length;
            int indexMiddle = (indexRight - indexLeft) / 2;
            double[] partLeft = getPart(array, indexLeft, indexMiddle);
            //System.arraycopy(array, indexLeft, partLeft, 0, indexMiddle);
            mergeSort(partLeft);
            double[] partRight = getPart(array, indexMiddle, indexRight);
            //System.arraycopy(array, indexMiddle, partRight, 0, indexRight);
            mergeSort(partRight);
            double[] result = merge(partLeft, partRight);
            System.arraycopy(result, 0, array, 0, array.length);
        }
    }

    private static double[] getPart(double[] array, int indexFrom, int indexTo) {
        double[] resultArray = new double[indexTo - indexFrom];
        System.arraycopy(array, indexFrom, resultArray, 0, resultArray.length);
        return resultArray;
    }

    private static double[] merge(double[] leftArray, double[] rightArray) {
        double[] resultArray = new double[leftArray.length + rightArray.length];
        for (int i = 0, rightPartIndex = 0, leftPartIndex = 0; i < resultArray.length; i++) {
            if (rightPartIndex == rightArray.length ||
                    (leftPartIndex < leftArray.length && leftArray[leftPartIndex] <= rightArray[rightPartIndex])) {
                resultArray[i] = leftArray[leftPartIndex++];
            } else {
                resultArray[i] = rightArray[rightPartIndex++];
            }
        }
        return resultArray;
    }
}
