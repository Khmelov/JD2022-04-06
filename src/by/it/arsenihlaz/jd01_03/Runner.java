package by.it.arsenihlaz.jd01_03;

import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "num", 3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        double[][] matrix = MatrixMaker.getMatrix();
        double[] vector = MatrixMaker.getVector();
        Helper.multiply(matrix, vector);
        double[][] matrixLeft = MatrixMaker.getMatrix();
        double[][] matrixRight = MatrixMaker.getMatrix();
        Helper.multiply(matrixLeft, matrixRight);
    }
}
