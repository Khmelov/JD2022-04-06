package by.it.arsenihlaz.jd01_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = step1(n);
        step2(array);
        step3(array);
    }

    private static int[][] step1(int n) {
        int max = 0;
        int min = 0;
        int[][] arr = new int[n][n];
        do {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    Random random = new Random();
                    arr[i][j] = random.nextInt(-n, (n + 1));
                }
            }
            for (int[] row : arr) {
                for (int element : row) {
                    if (element < min) {
                        min = element;
                    }
                    if (element > max) {
                        max = element;
                    }
                }
            }
        } while (max != n && min != -n);
        System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }

    public static int step2(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int firstElement = -1;
            int secondElement = -1;
            int counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] >= 0 && counter == 0) {
                    counter++;
                    firstElement = j;
                } else if (arr[i][j] >= 0 && counter != 0) {
                    secondElement = j;
                    break;
                }
            }
            if (firstElement >= 0 && secondElement >= 0) {
                for (int j = firstElement + 1; j < secondElement; j++) {
                    sum = sum + arr[i][j];
                }
            }
            System.out.println(sum);
        }
        return sum;
    }

    private static int[][] step3(int[][] arr) {
        boolean[] colRemove = new boolean[arr.length];
        boolean[] rowRemove = new boolean[arr[0].length];
        int max = 0;
        for (int[] row : arr) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        System.out.println(max);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == max) {
                    rowRemove[i] = true;
                    colRemove[j] = true;
                }
            }
        }
        System.out.println(Arrays.toString(colRemove));
        System.out.println(Arrays.toString(rowRemove));
        int colSize = 0;
        int rowSize = 0;
        for (boolean i : colRemove) {
            if (!i) {
                colSize++;
            }
        }
        for (boolean j : rowRemove) {
            if (!j) {
                rowSize++;
            }
        }
        int[][] resultArray = new int[rowSize][colSize];
        ArrayList<Object> tempList = new ArrayList<>();

        for (int i = 0; i < rowRemove.length; i++) {
            if (rowRemove[i] == false) {
                for (int j = 0; j < colRemove.length; j++) {
                    if (colRemove[j] == false) {
                        tempList.add(arr[i][j]);
                    }
                }
            }
        }
        System.out.println(tempList);
        int t = 0;
        for (int k = 0; k < resultArray.length; k++) {
            for (int m = 0; m < resultArray[0].length; m++) {
                resultArray[k][m] = (int) tempList.get(t);
                t++;
            }
        }
        System.out.println(Arrays.deepToString(resultArray));
        return resultArray;
    }
}




