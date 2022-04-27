package by.it.penkrat.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    static void step1(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int element : array) {
            if (max < element) {
                max = element;
            }
            if (min > element) {
                min = element;
            }
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] array) {
        double sum = 0;
        for (int element : array) {
            sum = sum + element;
        }

        double aver = sum / array.length;

        for (int element : array) {
            if (element < aver) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }


    static void step3(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (min > element) {
                min = element;
            }
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}

