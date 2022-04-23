package by.it.arsenihlaz.jd01_03;

import java.util.Random;

public class MatrixMaker {
    static double[] getVector() {
        double[] vector = new double[3];
        for (int i = 0; i < vector.length; i++) {
            Random random = new Random();
            vector[i] = random.nextInt(0, 5);
        }
        return vector;
    }
    static double[][] getMatrix() {
        double[][] matrix = new double[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Random random = new Random();
                matrix[i][j] = random.nextInt(0, 5);
            }
        }
        return matrix;
    }

}
