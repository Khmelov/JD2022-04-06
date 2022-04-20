package by.it.annazhegulovich.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    private static int n;
    private static int max;
    private static int min;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);

    }




    public static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        Random random = new Random();

        int max = n;
        int min = -n;
        int a = 0;
        int b = 0;
        do {
            for (int i = 0; i < arr.length; i++) {
                a = 0;
                b = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = (int) Math.round((Math.random() * (2 * n + 1)) - n);
                    if (max == arr[i][j]) {
                        a = 1;
                    }
                    if (min == arr[i][j]) {
                        b = 1;
                    }
                }
            }
        }
        while (a != 1 || b != 1);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        return arr;
    }

    public static int step2(int[][] arr) {
        int[][] step1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0 && arr[i + 1][j + 1] < 0) {
                    sum = sum + arr[i + 1][j + 1];
                } else continue;

            }
        }

        return sum;
    }
}


