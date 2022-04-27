package by.it.penkrat.jd01_02;

import java.util.Random;

public class Test {


    public static void main(String[] args) {
        int sum;
        int[][] matrix = feelMatrix();
        printMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            System.out.println("В " + i + "-й строке " + matrix[i].length + " элементов, их сумма = " + sum);
        }
    }

    private static int[][] feelMatrix() {
        Random rand = new Random(47);
        int arr[][] = new int[rand.nextInt(10) + 1][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[rand.nextInt(10) + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = rand.nextInt(20);
            }
        }
        return arr;
    }

    private static void printMatrix(int[][] arr) {
        System.out.println("Исходный массив:");
        for (int[] anArr : arr) {
            for (int anAnArr : anArr) {
                System.out.print(anAnArr + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    }

