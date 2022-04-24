package by.it.avramchuk.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array =InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"A", 4);
        double min = Helper.findMin(array);
        double max = Helper.findMax(array);
        Helper.sort(array);
        double[][]  test = new double[][] {{2,3}, {4,5}};
        double[] vector = new double[] {1,3};
        Helper.multiply(test, vector);
        Helper.multiply(test, test);

    }
}
