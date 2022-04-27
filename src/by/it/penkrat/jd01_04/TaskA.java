package by.it.penkrat.jd01_04;

import java.util.Scanner;

public class TaskA {

    static void printMulTable() {

        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {

        String trimLine = line.trim();
        String[] lineArray = trimLine.split(" ");

        double[] array = new double[lineArray.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(lineArray[i]);
        }
        double start = array[0];
        double last = array[array.length - 1];

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%1s[%1d]=%5.3f ", "V", i, array[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] > array[i]) {
                    double temp = array[i];
                    array[i] = array[j - 1];
                    array[j - 1] = temp;
                }
            }

        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%1s[%1d]=%5.3f ", "V", i, array[i]);
            if ((i + 1) % 4 == 0 || array[i] == 0) {
                System.out.println();
            }

        }
        System.out.println();



        for (int i = 0; i < array.length; i++) {
            if (array[i] == start) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        printMulTable();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        buildOneDimArray(line);

    }
}
