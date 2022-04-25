package by.it.marchenko.jd01_03;

import java.util.Locale;

/**
 * This class operate with input and output one dimensional array.
 */
public class InOut {
    private static final String INPUT_LINE_SEPARATOR = " ";
    private static final String ELEMENT_SEPARATOR = " ";

    /**
     * Convert string to one dimensional array with double values
     * @param inputLine - string for converting
     * @return array from inputLine with double values
     */
    static double[] getArray(String inputLine) {
        inputLine = inputLine.trim();
        String[] inputLineElements = inputLine.split(INPUT_LINE_SEPARATOR);
        double[] outputArray = new double[inputLineElements.length];
        for (int i = 0; i < inputLineElements.length; i++) {
            outputArray[i] = Double.parseDouble(inputLineElements[i]);
        }
        return outputArray;
    }

    /**
     * print inputArray in one line with ELEMENT_SEPARATOR between elements
     * @param inputArray - array from string
     */
    static void printArray(double[] inputArray) {
        for (double element : inputArray) {
            System.out.print(element + ELEMENT_SEPARATOR);
        }
        System.out.println();
    }

    /**
     * Print inputArray with formatting each element.
     * Sample: printArray({1, 2, 3, 4.12345 }, "A", 2)
     * Result:
     *  A[ 0 ] = 1.000     A[ 1 ] = 2.000
     *  A[ 2 ] = 3.000     A[ 3 ] = 4.123
     *
     * @param inputArray - array for printing
     * @param arrayName - printed array name
     * @param columnCount - amount of arrays element in one line
     */
    static void printArray(double[] inputArray, String arrayName, int columnCount) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.printf(Locale.ENGLISH,"%s[% -3d] = %-10.3f ", arrayName, i, inputArray[i]);
            if ((0 == (i + 1) % columnCount) || (i == inputArray.length - 1)) {
                System.out.printf("%n");
            }
        }
    }
}
