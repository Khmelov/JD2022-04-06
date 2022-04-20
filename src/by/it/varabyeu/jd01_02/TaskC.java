package by.it.varabyeu.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        step1(n);
//        step2();
//        step3();
    }

    public static int[][] step1(int n) {

        int[][] arr = new int[n][n];
        Random random = new Random();
        boolean leftBound = false;
        boolean rightBound = false;
        while (!leftBound && !rightBound) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = random.nextInt(n + n + 1) - n;
                    if (arr[i][j] == n) {
                        rightBound = true;
                    }
                    if (arr[i][j] == n * -1) {
                        leftBound = true;
                    }
//                    if (leftBound && rightBound) {
//                        for (int k = 0; k < n; k++) {
//                            System.out.println(Arrays.toString(arr[k]));
//                        }
//                        return arr;
//                    }
                }
            }
        }
        for (int k = 0; k < n; k++) {
            System.out.println(Arrays.toString(arr[k]));
        }
        return arr;
    }
}