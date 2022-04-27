package by.it.smirnov.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    static void step1(int[] arr) {


        for (int x : arr) {
            if (min > x) {
                min = x;
            }

        }
        for (int x : arr) {
            if (max < x) {
                max = x;
            }
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] arr) {
        double average = 0.0;
        for (int a :
                arr) {
            average += a;
        }
        average = (average / arr.length);
        for (int b :
                arr) {
            if (b < average) {
                System.out.print(b + " ");
            }
        }
        System.out.println();
    }

    static void step3(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min) {
                System.out.print(i + " ");
            }
        }
        System.out.println();


    }

}
