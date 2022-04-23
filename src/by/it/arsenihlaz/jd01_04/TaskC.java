package by.it.arsenihlaz.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }

    static void mergeSort(double[] array) {
        if (array.length > 1) {
            int left = 0;
            int right = array.length - 1;
            int midle = right / 2;
            double[] arrayLeft = getPart(array, left, midle);
            double[] arrayRight = getPart(array, midle + 1, right);
            mergeSort(arrayLeft);
            mergeSort(arrayRight);
            System.arraycopy(merge(arrayLeft, arrayRight), 0, array, 0, array.length);
        }
    }

    private static double[] getPart(double[] array, int left, int right) {
        double[] part = new double[(right - left) + 1];
        for (int i = 0; i < part.length; i++) {
            part[i] = array[left];
            left++;
        }
        return part;
    }


    private static double[] merge(double[] arrayLeft, double[] arrayRight) {
        double[] arraySort = new double[arrayLeft.length + arrayRight.length];

        int positionLeft = 0;
        int positionRight = 0;
        for (int i = 0; i < arraySort.length; i++) {
            if (positionLeft == arrayLeft.length) {
                arraySort[i] = arrayRight[positionRight];
                positionRight++;
                continue;
            }
            if (positionRight == arrayRight.length) {
                arraySort[i] = arrayLeft[positionLeft];
                positionLeft++;
                continue;
            }
            if (arrayLeft[positionLeft] < arrayRight[positionRight]) {
                arraySort[i] = arrayLeft[positionLeft];
                positionLeft++;
            } else if (arrayLeft[positionLeft] > arrayRight[positionRight]) {
                arraySort[i] = arrayRight[positionRight];
                positionRight++;
            }

        }
        for (int i = 0; i < arraySort.length; i++) {
            System.out.printf("%1s[% -3d]=%-1.3f ", "V", i, arraySort[i]);
        }
        return arraySort;
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
}

