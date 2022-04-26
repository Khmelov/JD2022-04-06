package by.it.marchenko.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    private static final String OUTPUT_ARRAY_NAME = "A";
    private static final int OUTPUT_ARRAY_COLUMN_COUNT = 3;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String inputLine = console.nextLine();
        double[] array = InOut.getArray(inputLine);

        InOut.printArray(array);
        InOut.printArray(array, OUTPUT_ARRAY_NAME, OUTPUT_ARRAY_COLUMN_COUNT);

        double min = Helper.findMin(array);
        double max = Helper.findMax(array);
        System.out.println(min + " " + max);
        Helper.sort(array);
        InOut.printArray(array);

        double[][] p = {{1, 2, 3}, {4, 5, 6}};
        double[][] q = {{1, 2}, {3, 4}, {5, 6}};
        double[] r = {1, 2, 3};
        double[][] matrixResult;
        double[] vectorResult;
        matrixResult = Helper.multiply(p, q);
        System.out.println(Arrays.deepToString(matrixResult));
        vectorResult = Helper.multiply(p, r);
        System.out.println(Arrays.toString(vectorResult));
    }
}
