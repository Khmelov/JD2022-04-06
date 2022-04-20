package by.it.arsenihlaz.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

class TaskA {
    public static void main(String[] args) {
        printMulTable();
        System.out.println("Enter an array, please...");
        Scanner scanner = new  Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }
    static void printMulTable(){

        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                int sum = i * j;
                System.out.printf("%1d*%1d=%-2d ", i, j, sum);
                if (j == 9) {
                    System.out.println();
                }
            }
        }
    }
    static void buildOneDimArray(String line) {
        String name = "V";
        int columnCount = 5;
        String trimLine = line.trim();
        String[] strings = trimLine.split(" ");
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        double firstIndex = array[0];
        double lastIndex = array[array.length-1];
        System.out.println("Input array:");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%1s[% -3d]=%-1.3f ", name, i, array[i]);
            if ((0 == ((i + 1) % columnCount)) || array.length - 1 == i) {
                System.out.println();
            }
        }
        Arrays.sort(array);
        System.out.println("Sort array:");
        columnCount = 4;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstIndex) {
                firstIndex = i;
            }
            if (array[i] == lastIndex) {
                lastIndex = i;
            }
            System.out.printf("%1s[% -3d]=%-1.3f ", name, i, array[i]);
            if ((0 == ((i + 1) % columnCount)) || array.length - 1 == i) {
                System.out.println();
            }
        }
        System.out.println("Index of first element" + "=" + firstIndex);
        System.out.println("Index of last element" + "=" + lastIndex);
    }
}
