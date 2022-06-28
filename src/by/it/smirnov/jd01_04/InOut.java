package by.it.smirnov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class InOut {

    static String scan() {
        Scanner keybd = new Scanner(System.in);
        String line = keybd.nextLine();
        return line;
    }

    static double[] getArray(String line) {
        line.trim();
        String[] lineArray = line.split(" ");
        int count = lineArray.length;
        double[] doubles = new double[count];
        for (int i = 0; i < count; i++) {
            doubles[i] = Double.parseDouble(lineArray[i]);
        }
        return doubles;
    }

    static void printArray(double[] array) {
        System.out.print(Arrays.toString(array));
        System.out.println();
    }

    static void printArray(double[] array, String name, int columnCount) {
        int colmnNumb = 1;
        for (int i = 0; i < array.length; i++) {
            System.out.print(name);
            System.out.printf("[% -1d ]=%-5.3f    ", i, array[i]);
            if ((colmnNumb % columnCount == 0) || (i == array.length - 1)) {
                System.out.println();
            }
            colmnNumb++;
        }


    }
}
