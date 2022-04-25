package by.it.kadulin.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        double[] array = InOut.getArray(line);
//        InOut.printArray(array);
//        InOut.printArray(array, "A", 5);
//        Helper.sort(array);
//        System.out.println(Arrays.toString(Helper.multiply(new double[][]{{1, 2, 3}, {4, 5, 6}}, new double[]{1, 2, 3})));
        double[][] matrix = Helper.multiply(new double[][]{{1, 2, 3}, {4, 5, 6}}, new double[][]{{1, 2}, {3, 4}, {5, 6}});
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("% -6.2f", matrix[i][j]);
            }
            System.out.println();
        }

    }
}
