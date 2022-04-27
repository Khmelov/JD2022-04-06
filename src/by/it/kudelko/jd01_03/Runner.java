package by.it.kudelko.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] array = InOut.getArray(line);
        double[][] matrix = InOut.getArray2();
        double [] vector = InOut.getArray3();
        double[][] matrixLeft = InOut.getArray4();
        double[][] matrixRight = InOut.getArray5();
        String name = "index";
        int columnCount = 2;

        System.out.println("Массив v");

        InOut.printArray(array);
        InOut.printArray(array, name, columnCount);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        Helper.multiply(matrix, vector);
        Helper.multiply(matrixLeft, matrixRight);
    }

}
