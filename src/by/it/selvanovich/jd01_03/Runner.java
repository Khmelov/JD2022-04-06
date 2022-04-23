package by.it.selvanovich.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "A", 4);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        double [][] matrix = InOut.generateMatrix(array.length);
        Helper.multiply(matrix, array);
        Helper.multiply(matrix, matrix);

    }
}
