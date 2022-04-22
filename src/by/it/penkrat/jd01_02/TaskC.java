package by.it.penkrat.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        step1(n);
        step2(step1(n));
        step3(step1(n));
    }

    public static int[][] step1(int n) {

        int[][] array = new int[n][n];
        Random random = new Random();

        boolean temp = false;
        do {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = random.nextInt(n + n + 1) - n;

                    if ((array[i][j] == -n) && (array[i][j] == n)) {
                        temp = true;
                        break;

                    }
                }
            }
        } while (temp);
        System.out.println(Arrays.deepToString(array));

        return array;
    }


    public static int step2(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int positive1 = 0;
            int positive2 = 0;
            boolean posFound = false;
            int counter = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0 && posFound) {
                    positive2 = j;
                    counter++;
                    break;
                }
                if (arr[i][j] > 0) {
                    positive1 = j;
                    posFound = true;
                    counter++;
                }
            }
            if (counter == 2) {
                for (int k = positive1 + 1; k < positive2; k++) {
                    sum += arr[i][k];
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    static int[][] step3(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        boolean[] delRows = new boolean[arr.length];
        boolean[] delCols = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (max == arr[i][j]) {
                    delRows[i] = true;
                    delCols[j] = true;
                }
            }
        }
        int rows = 0;
        for (boolean delRow : delRows) {
            if (!delRow) {
                rows++;
            }
        }
        int cols = 0;
        for (boolean delCol : delCols) {
            if (!delCol) {
                cols++;
            }
        }
        int[][] result = new int[rows][cols];
        for (int i = 0, iResult = 0; i < arr.length; i++) {
            if (delRows[i] == false) {
                for (int j = 0, jResult = 0; j < arr.length; j++) {
                    if (!delCols[j]){
                        result[iResult][jResult++]=arr[i][j];
                    }
                }
                iResult++;
            }
        }
        return result;
    }
}

