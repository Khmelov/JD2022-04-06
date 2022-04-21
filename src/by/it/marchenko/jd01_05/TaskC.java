package by.it.marchenko.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step6();
        TaskC2.main(args);
    }

    private static void step6() {
        final String INPUT_ARRAY_NAME = "A";
        final String OUTPUT_ARRAY_NAME = "B";
        final int INPUT_ARRAY_COLUMN = 6;
        final int OUTPUT_ARRAY_COLUMN = 5;
        final double MIN_VALUE = 3.5;
        
        double xStart = 5.33;
        double xEnd = 9.0;
        
        double xDelta = getRandomDelta(xStart, xEnd);

        double[] inputArray = getArray(xStart, xEnd, xDelta);

        System.out.printf("Массив %s[]%n", INPUT_ARRAY_NAME);
        printArray(inputArray, INPUT_ARRAY_NAME, INPUT_ARRAY_COLUMN);

        double[] outputArray = createArrayWithMinValue(inputArray);
        System.out.printf("%n Массив %s[] из элементов массива %s > %.1f%n",
                OUTPUT_ARRAY_NAME, INPUT_ARRAY_NAME, MIN_VALUE);
        printArray(outputArray, OUTPUT_ARRAY_NAME, OUTPUT_ARRAY_COLUMN);

        double geometricMean = calculateGeometricMean(outputArray);
        System.out.printf("Среднее геометрическое элементов больших %.1f равно %.3f%n",
                MIN_VALUE, geometricMean);
    }

    private static double getRandomDelta(double xStart, double xEnd) {
        final int MINIMUM_ELEMENTS_AMOUNT = 20;
        final int MAXIMUM_ELEMENTS_AMOUNT = 40;

        int stepNumber = (int) (random() *
                (MAXIMUM_ELEMENTS_AMOUNT - MINIMUM_ELEMENTS_AMOUNT + 1) + MINIMUM_ELEMENTS_AMOUNT);

        return (xEnd - xStart) / (stepNumber - 1);
    }
    
    private static double[] getArray(double xStart, double xEnd, double xDelta) {
        int stepNumber = (int) ((xEnd - xStart) / xDelta);
        double[] array = new double[stepNumber + 1];
        double x = xStart;
        for (int i = 0; i < array.length; i++) {
            array[i] = evalFunction(x);
            x += xDelta;
        }
        return array;
    }

    private static double evalFunction(double x) {
        return pow(pow(x, 2) + 4.5, 1d / 3);
    }

    private static void printArray(double[] array, String name, int column) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%3d ] = %-10.5f", name, i, array[i]);
            if ((i + 1) % column == 0 || i == array.length - 1) {
                System.out.println();
            }
        }
    }

    private static double[] createArrayWithMinValue(double[] inputArray) {
        final double MIN_VALUE = 3.5;
        Arrays.sort(inputArray);
        int minIndex = -Arrays.binarySearch(inputArray, MIN_VALUE) - 1;
        double[] outputArray = new double[inputArray.length - minIndex];
        System.arraycopy(inputArray, minIndex, outputArray, 0, outputArray.length);
        return outputArray;
    }

    private static double calculateGeometricMean(double[] array) {
        double value = 1;
        for (double element : array) {
            value *= element;
        }
        return pow(value, 1d/array.length);
    }
}
