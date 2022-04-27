package by.it.marchenko.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        //java.util.Scanner scanner = new java.util.Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : array) {
            if (element > max) {
                max = element;
            }
            if (element < min) {
                min = element;
            }
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum = sum + element;
        }
        double avg = (double)sum / array.length;
        for (int element : array) {
            if (element < avg) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    private static void step3(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
