package by.it.marchenko.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC2 {
    private static final String INPUT_ARRAY_NAME = "A";
    private static final String OUTPUT_ARRAY_NAME = "B";

    public static void main(String[] args) {

        int[] inputArray = getRandomArray();
        System.out.println(Arrays.toString(inputArray));

        int[] inputArrayDimension = calculateOutputDimension(inputArray);
        boolean indexByRow = true;
        System.out.printf("Array %s <index to rows>%n", INPUT_ARRAY_NAME);
        printArray(inputArray, INPUT_ARRAY_NAME, inputArrayDimension, indexByRow);

        int[] outputArray = createPercentRangeArray(inputArray);
        System.out.println(Arrays.toString(outputArray));
        int[] outputArrayDimension = calculateOutputDimension(outputArray);
        System.out.printf("Array %s <index to columns>%n", OUTPUT_ARRAY_NAME);

        printArray(outputArray, OUTPUT_ARRAY_NAME, outputArrayDimension, !indexByRow);
    }

    private static int[] getRandomArray() {
        final int ARRAY_SIZE = 31;
        final int MINIMUM_VALUE = 103;
        final int MAXIMUM_VALUE = 450;
        int[] array = new int[ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (random() * (MAXIMUM_VALUE - MINIMUM_VALUE + 1) + MINIMUM_VALUE);
        }
        return array;
    }

    private static int[] createPercentRangeArray(int[] array) {
        final int PERCENT_RANGE = 10;

        int outputArraySize = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i * PERCENT_RANGE) {
                outputArraySize++;
            }
        }
        int[] outputArray = new int[outputArraySize];
        for (int i = 0, indexOutputArray = 0; i < array.length; i++) {
            if (array[i] > i * PERCENT_RANGE) {
                outputArray[indexOutputArray++] = array[i];
            }
        }
        Arrays.sort(outputArray);
        return outputArray;
    }

    private static int[] calculateOutputDimension(int[] array) {
        final int MAXIMUM_COLUMN = 5;
        int rowsQuantity = (int) Math.ceil((double) array.length / MAXIMUM_COLUMN);
        int columnQuantity = (int) Math.ceil((double) array.length / rowsQuantity);
        int[] arrayDimension = {rowsQuantity, columnQuantity};
        System.out.println(rowsQuantity + " x " + columnQuantity);
        return arrayDimension;
    }

    private static void printArray(int[] array, String name, int[] arrayDimension, boolean indexByRow) {
        int rows = arrayDimension[0];
        int column = arrayDimension[1];
        int[][] valueArrayToPrint = new int[rows][column];
        int[][] indexArrayToPrint = new int[rows][column];

        //printFirstLine(column);
        if (indexByRow) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < column; j++) {
                    int currentIndex = i * column + j;
                    if (currentIndex < array.length) {
                        indexArrayToPrint[i][j] = currentIndex;
                        valueArrayToPrint[i][j] = array[currentIndex];
                    } else {
                        indexArrayToPrint[i][j] = array.length;
                    }
                }
            }
        } else {
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < rows; j++) {
                    int currentIndex = i * column + j;
                    if (currentIndex < array.length) {
                        indexArrayToPrint[j][i] = currentIndex;
                        valueArrayToPrint[j][i] = array[currentIndex];
                    } else {
                        indexArrayToPrint[j][i] = array.length;
                    }
                }
            }
        }


        System.out.println(Arrays.deepToString(indexArrayToPrint));
        System.out.println(Arrays.deepToString(valueArrayToPrint));


        //       for (int i = 0; i < indexArrayToPrint.length; i++) {
        //           for (int j = 0; j < indexArrayToPrint[i].length; j++) {
        //               System.out.printf("%s[%3d ] = %-8d", name, indexArrayToPrint[i][j], valueArrayToPrint[j][i]);
        //           }
        //           System.out.println();
        //       }


    }
}
