package by.it.kameisha.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        arr = step1(n);
        step2(arr);
        int[][] newArray = step3(arr);
    }

    private static int[][] step1(int n) {
        int[][] array = new int[n][n];
        Random random = new Random();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (min != -n || max != n) {
            min = 0;
            max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = random.nextInt(-n, n + 1);
                    if (array[i][j] == -n) {
                        min = array[i][j];
                    }
                    if (array[i][j] == n) {
                        max = array[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
        System.out.println();
        return array;
    }

    private static int step2(int[][] array) {
        boolean flag;
        int sum = 0;
        int temp;
        for (int i = 0; i < array.length; i++) {
            flag = false;
            temp = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (flag && array[i][j] >= 0) {
                    break;
                }
                if (flag && array[i][array.length - 1] < 0) {
                    break;
                }
                if (array[i][j] >= 0) {
                    flag = true;
                }
                if (flag && array[i][j] < 0) {
                    temp = array[i][j];
                }
                sum = sum + temp;
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] array) {
        int max = Integer.MIN_VALUE;
        boolean[] deletehorizontal = new boolean[array.length];
        boolean[] deletevertical = new boolean[array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        int horizont = 0;
        int vertical = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] == max) {
                    deletehorizontal[i] = true;
                    deletevertical[j] = true;
                } else {
                    deletehorizontal[i] = false;
                    horizont++;
                    deletevertical[j] = false;
                    vertical++;
                }
            }
        }
        int[][] newArray = new int[vertical][horizont];
        horizont = 0;
        vertical = 0;
        for (int i = 0; i < array.length; i++)
            if (deletehorizontal[i] == false) {
                vertical++;
                for (int j = 0; j < array[i].length; j++) {
                    if (deletevertical[j] == false) {
                        horizont++;
                        newArray[vertical - 1][horizont - 1] = array[i][j];
                    }
                }
            }
        return newArray;
    }

}
