package by.it.kadulin.jd01_04;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        buildOneDimArray("5 6 3 2 8 1 4 11 9");
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
//        InOut.printArray(array, "V", 5);
//        System.out.println();
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println();
        System.out.println("Index of first element=" + binarySearch(array, firstElement));
        System.out.println("Index of last element=" + binarySearch(array, lastElement));
    }

    static int binarySearch(double[] array, double value) {
        int lowIndex = 0;
        int highIndex = array.length - 1;
        int indexElement = -1;
        while(lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            if (value == array[midIndex]) {
                indexElement = midIndex;
                break;
            }
            else if (value < array[midIndex]) {
                highIndex = midIndex - 1;
            }
            else if (value > array[midIndex]) {
                lowIndex = midIndex + 1;
            }
        }
        return indexElement;
    }

//5 6 3 2 8 1 4 9
//1 2 3 4 5 6 8 9
    static void mergeSort(double[] array) {
        int sizeArray = array.length / 2;
        double[] left = getPart(array, 0, sizeArray - 1);
        double[] right = getPart(array, sizeArray, array.length - 1);
        if (left.length != 1) {
            mergeSort(left);
        }
        if (right.length != 1) {
            mergeSort(right);
        }
        double[] result = merge(left, right);
        System.arraycopy(result, 0, array, 0, result.length);
    }

    private static double[ ] getPart(double[ ] array, int left, int right) {
        double[] newPart = new double[right - left + 1];
        for (int i = 0; i < newPart.length; i++) {
            newPart[i] = array[left + i];
        }
        return newPart;
    }

    private static double[ ] merge(double[ ] part1, double[ ] part2) {
        double[] resultArray = new double[part1.length + part2.length];
        int countRight = 0;
        int countLeft = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (countLeft == part1.length) {
                resultArray[i] = part2[countRight];
                countRight++;
                continue;
            }
            if (countRight == part2.length) {
                resultArray[i] = part1[countLeft];
                countLeft++;
                continue;
            }
            if (part1[countLeft] < part2[countRight]) {
                resultArray[i] = part1[countLeft];
                countLeft++;
            }
            else if(part1[countLeft] > part2[countRight]) {
                resultArray[i] = part2[countRight];
                countRight++;
            }
        }
        return resultArray;
    }
}
