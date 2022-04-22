package by.it.kameisha.jd01_05;

import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
        System.out.println("╗");
        System.out.println("║");
        System.out.println("╝");
    }

    private static void step1() {
        Random randomX = new Random();
        int length = randomX.nextInt(20, 41);
        double[] array = new double[length];
        System.out.println("Массив A[]");
        int count = 0;
        for (double i = 5.33 ; i <= 9.0; i+=(9-5.33)/(length-1)) {
            array[count] = cbrt(pow(i, 2) + 4.5);
            printArray('A', count, array);
            count++;
        }
        System.out.println();
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                count++;
            }
        }
        double[] newArray = new double[count];
        count = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > 3.5) {
                newArray[count] = array[j];
                count++;
            }
        }
        double result = 0;
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int i = 0; i < newArray.length; i++) {
            result = result + newArray[i];
            printArray('B', i, newArray);
        }
        result = pow(result, 1.0 / newArray.length);
        System.out.printf("Среднее геометрическое массива B = %-8.5f%n", result);
    }

    private static void printArray(char A, int i, double[] array) {
        System.out.printf("%1c[ %-2d] =%8.5f    ", A, i, array[i]);
        if (i + 1 == array.length || (i + 1) % 5 == 0) {
            System.out.println();
        }
    }

    private static void step2() {
        Random randomElement = new Random();
        int[] array = new int[31];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomElement.nextInt(103, 450);
        }
        int[] newArray = getNewArray(array);

    }

    private static int[] getNewArray(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if ((double) array[i] * 0.1 > i) {
                count++;
            }
        }
        int[] newArray = new int[count];
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if ((double) array[i] * 0.1 > i) {
                newArray[count] = array[i];
                count++;
            }
        }
        sort(newArray);
        return newArray;
    }
    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minElement = array[i];
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (minElement > array[j]) {
                    minElement = array[j];
                    minElementIndex = j;
                }
            }
            if (i != minElementIndex) {
                int temporary = array[i];
                array[i] = array[minElementIndex];
                array[minElementIndex] = temporary;
            }
        }
    }
}


