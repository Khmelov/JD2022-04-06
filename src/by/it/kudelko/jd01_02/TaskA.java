package by.it.kudelko.jd01_02;


import java.util.Scanner;

public class TaskA {
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
        int l = 0;
        for (int element : arr) {
            l = l + element;
        }
        double k = l / arr.length;
        for (int element : arr) {
            if (element < k) {
                System.out.print(element + " ");
            }
        }
        System.out.println(" ");
    }

    static void step3(int[] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (min > element) {
                min = element;
            }
        }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == min) {
                    System.out.print(i + " ");
                }
            }
        }
    }
