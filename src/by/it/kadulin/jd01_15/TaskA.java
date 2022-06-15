package by.it.kadulin.jd01_15;

import by.it.kadulin.jd01_14.Util;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = createMatrix(6, 4, -15, 15);
        String fileName = Util.getPath(TaskA.class, "matrix.txt");
        printMatrix(matrix, fileName);
        String text = readFile(fileName);
        System.out.println(text);


    }

    private static String readFile(String fileName) {
        StringBuilder out = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine();
                out.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("io error", e);
        }
        return out.toString();
    }

    private static void printMatrix(int[][] matrix, String fileName) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("io error", e);
        }
    }

    private static int[][] createMatrix(int rows, int cols, int minValue, int maxValue) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
            }
        }
        return matrix;
    }
}
