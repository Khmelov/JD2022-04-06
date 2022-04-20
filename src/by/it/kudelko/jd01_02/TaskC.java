package by.it.kudelko.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        step1(n);
        step2(step1(n));

    }

    static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        int min = -n;
        int max = n;
        int y = 0;
        int v = 0;
        do {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = (int) (Math.random() * ((n + 1) - (-(n + 1))) - (n + 1));
                    if (min == arr[i][j]) {
                        y = 1;
                    }
                    if (max == arr[i][j]) {
                        v = 1;
                    }
                }
            }
            if (y != 1 || v != 1) {
                y = 0;
                v = 0;
            }
        } while (v != 1 || y != 1);

        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr[k].length; l++) {
                System.out.print(arr[k][l] + " ");
            }
            System.out.println();
        }
        return arr;
    }

    static int step2(int[][] arr) {
        System.out.println();
        int sum = 0;
        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr[k].length; l++) {
                System.out.print(arr[k][l] + " ");
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    //                   if (arr[i][j] > 0 & arr[i][j] < 0) {
                    //                       while (arr[i][j] < 0) {
                    sum = sum + arr[i][j];
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(sum);
        return sum;
    }
}


