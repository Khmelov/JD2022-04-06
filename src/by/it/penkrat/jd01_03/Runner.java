package by.it.penkrat.jd01_03;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        double[] array = InOut.getArray(line);

        InOut.printArray(array);
        InOut.printArray(array, "My Array", 4);

        Helper.findMax(array);
        Helper.findMin(array);
        Helper.sort(array);


        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        double[][] matrix = new double[m][n];
        double[] vector = new double[n];
        Helper.multiply(matrix, vector);


        double[][] matrixLeft = new double[m][n];
        double[][] matrixRight = new double[n][k];
        Helper.multiply(matrixLeft,matrixRight);

    }
}
