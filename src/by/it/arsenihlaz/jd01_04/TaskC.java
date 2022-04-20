package by.it.arsenihlaz.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

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
        double lastIndex = array[array.length - 1];
        System.out.println("Input array:");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%1s[% -3d]=%-1.3f ", name, i, array[i]);
            if ((0 == ((i + 1) % columnCount)) || array.length - 1 == i) {
                System.out.println();
            }
        }
        mergeSort(array);
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

    static void mergeSort(double[] array) {
        getPart(array, array.length / 2, array.length - array.length / 2);
        merge(new double[]{}, new double[]{});
    }

    private static double[] getPart(double[] array, int left, int right) {
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array;
        }
        double[] arrayLeft = new double[left];
        System.arraycopy(array, 0, arrayLeft, 0, left);
        double[] arrayRight = new double[right];
        System.arraycopy(array, arrayLeft.length, arrayRight, 0, right);
        arrayLeft = getPart(arrayLeft, left, right);
        arrayRight = getPart(arrayRight, left, right);
        System.out.print(Arrays.toString(merge(arrayLeft, arrayRight)));
        return merge(arrayLeft, arrayRight);
    }

    private static double[] merge(double[] arrayLeft, double[] arrayRight) {
        double[] arraySort = new double[arrayLeft.length + arrayRight.length];
        System.arraycopy(arrayLeft, 0, arraySort, 0, arrayLeft.length);
        System.arraycopy(arrayRight, arrayLeft.length, arraySort, 0, arrayRight.length);
        int positionLeft = 0;
        int positionRight = 0;
        for (int i = 0; i < arrayLeft.length; i++) {
            if (arrayLeft[i - positionLeft] <= arrayRight[i - positionRight]) {
                arraySort[i] = arrayLeft[i];
                positionLeft++;
            } else if (positionLeft == arrayLeft.length) {
                arraySort[i] = arrayRight[i];
                positionRight++;
            } else if (positionRight == arrayRight.length) {
                arraySort[i] = arrayLeft[i];
                positionLeft++;
            } else
                arraySort[i] = arrayRight[i];
            positionRight++;

        }
        for (int i = 0; i < arraySort.length; i++) {
            System.out.printf("%1s[% -3d]=%-1.3f ", "V", i, arraySort[i]);
        }
        return arraySort;
    }
}

