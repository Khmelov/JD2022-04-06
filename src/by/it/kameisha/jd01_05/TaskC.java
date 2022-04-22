package by.it.kameisha.jd01_05;

import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        Random randomX = new Random();
        int length = randomX.nextInt(20, 41);
        double[] array = new double[length];
        System.out.println("Массив A[]");
        int count = 0;
        for (double i = 5.33; i <= 9.0; i += (9 - 5.33) / (length - 1)) {
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
        printStep2Array(array);
        printStep2newArray(newArray);

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

    private static void printStep2Array(int[] array) {
        int columns = 0;
        int min = 5;
        for (int i = 2; i < 5; i++) {
            if (i - array.length % i <= min) {
                min = i - array.length % i;
                columns = i;
            }
        }
        System.out.println("╔" + "══════════════╦".repeat(columns - 1) + "═".repeat(14) + "╗");
        for (int i = 0; i < array.length - array.length % columns; i++) {
            System.out.printf("║%2c[ %-2d] = %3d ", 'A', i, array[i]);
            if (i == array.length - 1 || (i + 1) % columns == 0) {
                System.out.println("║");
                System.out.println("╠" + "══════════════╬".repeat(columns - 1) + "═".repeat(14) + "╣");
            }
        }
        for (int i = array.length - array.length % columns; i < array.length; i++) {
            System.out.printf("║%2c[ %-2d] = %3d ", 'A', i, array[i]);
        }
        System.out.println("║" + "              ║".repeat(columns - array.length % columns));
        System.out.println("╚" + "══════════════╩".repeat(columns - 1) + "═".repeat(14) + "╝");
        System.out.print("");
    }

    private static void printStep2newArray(int[] array) {
        int columns = 0;
        int min = 5;
        for (int i = 2; i < 5; i++) {
            if (i - array.length % i <= min) {
                min = i - array.length % i;
                columns = i;
            }
        }
        System.out.println("╔" + "══════════════╦".repeat(columns - 1) + "═".repeat(14) + "╗");
        int count;
        for (int i = 0; i < array.length / columns; i++) {
            count = 0;
            for (int j = i; j < array.length-array.length%columns; j += array.length / columns) {
                count++;
                System.out.printf("║%2c[ %-2d] = %3d ", 'B', j, array[j]);
                if (j == array.length - 1 || count == columns) {
                    System.out.println("║");
                    System.out.println("╠" + "══════════════╬".repeat(columns - 1) + "═".repeat(14) + "╣");
                }
            }
        }
        System.out.println("║" + "              ║".repeat(columns - array.length % columns));
        System.out.println("╚" + "══════════════╩".repeat(columns - 1) + "═".repeat(14) + "╝");
        System.out.print("");
    }
}


