package by.it.marchenko.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] myArray = step1(n);

        System.out.println(step2(myArray));

        int[][] subArray = step3(myArray);
        System.out.println(Arrays.deepToString(subArray));
    }

    private static int[][] step1(int size) {
        int[][] array = new int[size][size];
        boolean containMax = false;
        boolean containMin = false;
        while (!(containMin && containMax)) {
            containMax = false;
            containMin = false;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    array[i][j] = (int) (Math.random() * (size * 2 + 1)) - size;
                    if (array[i][j] == -size) {
                        containMin = true;
                    } else if (array[i][j] == size) {
                        containMax = true;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(array));
        return array;
    }

    private static int step2(int[][] array) {
        int sum = 0;
        for (int[] row : array) {
            boolean isFirstPositive = false;
            boolean isSecondPositive = false;
            int interSum = 0;
            for (int element : row) {
                if (element > 0) {
                    if (isFirstPositive) {
                        isSecondPositive = true;
                        break;
                    } else {
                        isFirstPositive = true;
                    }
                } else if (element < 0 && isFirstPositive) {
                    interSum += element;
                }
            }
            if (isSecondPositive) {
                sum += interSum;
            }
        }
    return sum;
    }

    private static int[][] step3(int[][] array) {

        int max = Integer.MIN_VALUE;  // for general case if max element in the massive not correspond to dimension

        // define index massive. First index - lines amount; second index = rows amount
        final int INDEX_MASSIVE = 2;
        boolean[][] toRemove = new boolean[INDEX_MASSIVE][array.length];

        // define of the output massive dimension
        int subMassiveLines = array.length;
        int subMassiveRows = array[0].length;

        // search index of lines and rows with max element
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                    //clear index massive
                    for (int k = 0; k < INDEX_MASSIVE; k++) {
                        Arrays.fill(toRemove[k], false);
                    }
                    //add i and j to index massive
                    toRemove[0][i] = true;
                    subMassiveLines = array.length - 1;
                    toRemove[1][j] = true;
                    subMassiveRows = array.length - 1;
                } else if (max == array[i][j]) {
                    //add i and j to index massive
                    if (!toRemove[0][i]) {
                        toRemove[0][i] = true;
                        subMassiveLines--;
                    }
                    if (!toRemove[1][j]) {
                        toRemove[1][j] = true;
                        subMassiveRows--;
                    }
                }
            }
        }

        // create new array with deleted lines and rows
        int[][] subArray = new int[subMassiveLines][subMassiveRows];
        int subArrayI = 0, subArrayJ = 0;
        for (int i = 0; i < array.length; i++) {
            if (!toRemove[0][i]) {
                for (int j = 0; j < array[i].length; j++) {
                    if (!toRemove[1][j]) {
                        subArray[subArrayI][subArrayJ] = array[i][j];
                        if (subArrayJ < subMassiveRows - 1) {
                            subArrayJ++;
                        } else {
                            subArrayJ = 0;
                        }
                    }
                }
                if (subArrayI < subMassiveLines - 1) {
                    subArrayI++;
                }
            }
        }
        printArray(subArray);
        return subArray;
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

