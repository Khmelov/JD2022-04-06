package by.it.smirnov.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static int n;
    public static int[][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n][n];
        int[][] arr1;
        int sum;
        int[][] arr3;
        arr1 = step1(n);
        sum = step2(arr);
        arr3 = step3(arr);
    }

    public static int[][] step1(int n) {
        int a = 0;
        int b = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Random random = new Random();
                    arr[i][j] = random.nextInt(n * 2 + 1) - n;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == n) a = n;
                    else if (arr[i][j] == -n)
                        b = -n;
                }
            }
            if (a == n && b == -n)
                break;
        }
        System.out.println(Arrays.deepToString(arr));
        return arr;
    }
    public static int step2(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, k = 0; j < arr[0].length; j++) {
                if (arr[i][j] > 0) {
                    for (int b = j + 1; b < arr[0].length; b++) {
                        if (arr[i][b] > 0) break;
                        k = k + arr[i][b];
                        if (b > arr[0].length - 1) k = 0;
                    }
                    sum = sum + k;
                    break;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static int[][] step3(int[][] arr) {
        boolean[][] crap = new boolean[arr.length][arr[0].length];
        int[][] newarr;
        int max = Integer.MIN_VALUE;
        //ищем максимальное число в таблице
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > max) max = arr[i][j];
            }
        }
        for (int i = 0; i < arr.length; i++) { // заполняем таблицу boolean
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == max) {
                    for (int k = 0; k < arr.length; k++) {
                        crap[i][k] = true;
                        crap[k][j] = true;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(crap));
        int x = 0, y = 0; // узнаем размеры нового массива
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (crap[i][j] == false) {
                    x = x + 1;
                }
            }
            if (x > 0) break;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (crap[j][i] == false) {
                    y = y + 1;
                }
            }
            if (y > 0) break;
        }
        newarr = new int[y][x]; // заполняем новый массив
        for (int i = 0, a = 0; i < crap.length; i++) {
            for (int j = 0, b = 0; j < crap[0].length; j++) {
                if (crap[i][j] == false) {
                    newarr[a][b] = arr[i][j];
                    if (b < (x - 1)) b = b + 1;
                    else {
                        b = 0;
                        a = a + 1;
                    }
                }
            }
            //if (newarr[a][0] != 0) a = a + 1; // а если строка начинается с нуля?
            if (a == y) break;
        }
        System.out.println(x + " " + y);
        System.out.println(Arrays.deepToString(newarr));
        return newarr;
    }

}