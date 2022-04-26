package by.it.arsenihlaz.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        step2(step1(n));
    }

    private static int[][] step1(int n) {
        int max = 0;
        int min = 0;
        int[][] arr = new int[n][n];
        do {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
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
        System.out.print(Arrays.deepToString(arr));
        return arr;
    }


    private static int step2(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] >= 0) {
                    counter++;
                }
            }
            if (counter > 1){
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i][j] >= 0) {
                   if (arr[i][j+1] >= 0){
                        break;
                    }
                   for (;arr[i][j+1] < 0; j++) {
                        sum = sum + arr[i][j+1];
                    }
                    }
                }
                }
            System.out.println(sum);
            }
        return sum;
    }
}




