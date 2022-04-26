package by.it.ragach.jd01_04;

import java.util.Locale;

public class InOut {

    private static final String SPLITTER = " ";
    private static final String SPACE = " ";

    static double[] getArray(String line) {
        String trimline = line.trim();
        String[] strings = trimline.split(SPLITTER);
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);

        }
        return array;
    }

    static void printArray(double[] array) {
        for (double element : array) {

            System.out.print(element + SPACE);

        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(Locale.ENGLISH,"%s[% -3d]=%-9.4f ", name, i, array[i]);
            if (array.length - 1 == i || 0 == (i + 1) % columnCount) {

            }


        }


    }


}

