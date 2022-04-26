package by.it.kameisha.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
    }

    static void buildOneDimArray(String line) {
        double[] array = getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        printArray(array, "V", 5);
        double[] arraySorted = new double[array.length];
        mergeSort(array);
        printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElement) {
                System.out.println("Index of first element=" + i);
                break;
            }

        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == lastElement) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }

    private static double[] getArray(String line) {
        String trimLine = line.trim();
        String[] strings = trimLine.split(" ");
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        return array;
    }

    private static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("%s[% -3d]=%-10.3f", name, i, array[i]);
            if (i == array.length - 1 || (i + 1) % columnCount == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    static void mergeSort(double[] array) {
        getPart(array, array.length / 2,(array.length / 2) + 1);

    }

    private static double[ ] getPart(double[ ] array, int left, int right) {
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array;
        }
        double[] part1 = Arrays.copyOfRange(array, 0,left );
        double[] part2 = Arrays.copyOfRange(array,right , array.length);
        getPart(part1,0,left);
        getPart(part2,right, array.length);
        array = merge(part1,part2);
        return array;
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] array = new double[part1.length + part2.length];
        int left = 0;
        int rigth = 0;
        for (int i = 0; i < array.length; i++) {
            if (left == part1.length) {
                array[i] = part2[rigth];
                rigth++;
            } else if (rigth == part2.length) {
                array[i] = part1[left];
                left++;
            } else if (part1[left] < part2[rigth]) {
                array[i] = part1[left];
                left++;
            } else if (part1[left] > part2[rigth]) {
                array[i] = part2[rigth];
                rigth++;
            }
        }
        return array;
    }


}
