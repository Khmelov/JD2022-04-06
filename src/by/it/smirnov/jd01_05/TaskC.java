package by.it.smirnov.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        taskC1();
        taskC2();
    }

    private static void taskC1() {
        System.out.println("Основной массив A[]:");
        int colNumb = 1;
        int colNumbB = 1;
        int arrayLength = 26;
        int arrBLength = 0;
        double[] array = new double[arrayLength];
        int i = 0;
        for (double x = 5.33; x <= 9; x = x + 0.1468) {
            array[i] = cbrt(pow(x, 2) + 4.5);
            System.out.printf("A [ %2d ] = %7.5f  ", i, array[i]);
            if (colNumb % 5 == 0 || i == arrayLength - 1) System.out.println();
            if (array[i] > 3.5) arrBLength++;
            i++;
            colNumb++;

        }
        System.out.println("Новый массив В[] из элементов больше 3,5:");
        double[] arrB = new double[arrBLength];
        for (int j = 0, k = 0; k < arrBLength; j++) {
            if (array[j] > 3.5) {
                arrB[k] = array[j];
                System.out.printf("B [ %2d ] = %7.5f  ", k, arrB[k]);
                if (colNumbB % 5 == 0 || k == arrB.length - 1) System.out.println();
                k++;
                colNumbB++;
            }
        }
        double multiAll = 1;
        for (int j = 0; j < arrB.length; j++) {
            multiAll = multiAll * arrB[j];
        }
        double averageGeo = pow(multiAll, (1.0 / arrB.length));
        System.out.printf("Среднее геометрическое чисел массива В = %7.5f%n%n", averageGeo);

    }

    private static void taskC2() {
        int[] array = new int[31];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = 103 + (int) (round(random() * 347));
            double part = (double) array[i] / 10;
            if (part > i) {
                count++;
            }
        }
        int[] arrayFaceControl = new int[count];
        for (int i = 0, j = 0; j < arrayFaceControl.length; i++) {
            double part = (double) array[i] / 10;
            if (part > i) {
                arrayFaceControl[j] = array[i];
                j++;
            }
        }
        printTabA(array);
        printTabB(arrayFaceControl);

    }

    private static void printTabA(int[] array) {
        int rows = array.length / 5;
        if (array.length % 5 != 0) rows = (array.length / 5) + 1;
        System.out.printf("╔════════════╦════════════╦════════════╦════════════╦════════════╗%n");
        for (int i = 0; i < rows * 5; i++) {
            if ((i + 1) % 5 != 0 && i < array.length) {
                System.out.printf("║ A[%2d]=%4d ", i, array[i]);
            }
            else if ((i + 1) % 5 == 0 && i < array.length) {
                System.out.printf("║ A[%2d]=%4d ║%n", i, array[i]);
            }
            else if ((i + 1) % 5 != 0 && i >= array.length) {
                System.out.print("║            ");
            }
            else if ((i + 1) % 5 == 0 && i >= array.length) System.out.printf("║            ║%n");
            if ((i + 1) % 5 == 0 && i + 1 < array.length) {
                System.out.printf("╠════════════╬════════════╬════════════╬════════════╬════════════╣%n");
            }
        }

        System.out.printf("╚════════════╩════════════╩════════════╩════════════╩════════════╝%n");
        }

    private static void printTabB(int[] array) {
        int rows = array.length / 5;
        int count = 1;
        if (array.length % 5 != 0) rows = (array.length / 5) + 1;
        System.out.printf("╔════════════╦════════════╦════════════╦════════════╦════════════╗%n");
        for (int j = 0; j < rows; j++) {
            for (int i = j; i < rows * 5; i = i + rows) {
                if (count % 5 != 0 && i < array.length) {
                    System.out.printf("║ B[%2d]=%4d ", i, array[i]);
                } else if (count % 5 == 0 && i < array.length) {
                    System.out.printf("║ B[%2d]=%4d ║%n", i, array[i]);
                } else if (count % 5 != 0 && i >= array.length) {
                    System.out.print("║            ");
                } else if (count % 5 == 0 && i >= array.length) System.out.printf("║            ║%n");
                if (count % 5 == 0 && i != rows * 5 - 1) {
                    System.out.printf("╠════════════╬════════════╬════════════╬════════════╬════════════╣%n");
                }
                count++;
            }
        }

        System.out.printf("╚════════════╩════════════╩════════════╩════════════╩════════════╝%n");
    }
    }
