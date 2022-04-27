package by.it.machuga.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "X", 5);
        double min = Helper.findMin(array);
        System.out.println(min);
        double max = Helper.findMax(array);
        System.out.println(max);
        Helper.sort(array);
        InOut.printArray(array);
        double[][] matrixA = new double[2][3];
        matrixA[0] = InOut.getArray(scanner.nextLine());
        matrixA[1] = InOut.getArray(scanner.nextLine());
        double[][] matrixB = new double[3][3];
        matrixB[0] = InOut.getArray(scanner.nextLine());
        matrixB[1] = InOut.getArray(scanner.nextLine());
        matrixB[2] = InOut.getArray(scanner.nextLine());
        double[][] multiplyResultMatrixMatrix = Helper.multiply(matrixA, matrixB);
        for (double[] row : multiplyResultMatrixMatrix) {
            InOut.printArray(row);
        }
        double[] vector = InOut.getArray(scanner.nextLine());
        double[] multiplyResultMatrixVector = Helper.multiply(matrixB, vector);
        InOut.printArray(multiplyResultMatrixVector);
    }
}
