package by.it.kadulin.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);

    }

    static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int element : arr) {
            if (min > element) {
                min = element;
            }
            if (max < element) {
                max = element;
            }
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        double avg = (double) sum / arr.length;
        for (int element : arr) {
            if (element < avg) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    static void step3(int[] arr) {
        int min = 0;
        for (int el : arr) {
            if (min > el) {
                min = el;
            }
        }
        for (int i = arr.length -1; i >= 0; i--) {
            if (arr[i] == min) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
