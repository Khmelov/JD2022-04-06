package by.it.smirnov.jd01_03;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Ввод строки:");
        //String line = InOut.scan();
        String line = "45 6 234 778 34 7 23 68";
        System.out.println(line);

        double[] array = InOut.getArray(line);
        System.out.println("Неотформатированный массив:");
        InOut.printArray(array);
        System.out.println("Отформатированный массив:");
        InOut.printArray(array, "M1", 4);

        System.out.printf("Максимальное число = %s%n", Helper.findMax(array));
        System.out.printf("Минимальное число = %s%n", Helper.findMin(array));

        Helper.sort(array);
        System.out.println("Отсортированный массив:");
        InOut.printArray(array, "M2", 4);

        double[] vector = {4.5, 36.7, 23.5, 48, 7, 29.0};
        double[][] matrixL = new double[2][3];
        matrixL[0][0] = 2;
        matrixL[0][1] = 3;
        matrixL[0][2] = 4;
        matrixL[1][0] = 1;
        matrixL[1][1] = 2;
        matrixL[1][2] = 3;
        double[][] matrixR = new double[3][2];
        matrixR[0][0] = 1;
        matrixR[0][1] = 2;
        matrixR[1][0] = 2;
        matrixR[1][1] = 3;
        matrixR[2][0] = 3;
        matrixR[2][1] = 4;

        double[] result1 = Helper.multiply(matrixL, vector);
        System.out.println("Умножение массива и вектора:");
        InOut.printArray(result1, "M3", 5);
        double[][] result2 = Helper.multiply(matrixL, matrixR);
        System.out.println("Умножение массивов:");
        for (int i = 0; i < result2.length; i++) {
            for (int j = 0; j < result2[0].length; j++) {
                System.out.printf("M4[%6.2f] ", result2[i][j]);
            }
            System.out.println();
        }
    }
}
