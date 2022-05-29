package by.it.kudelko.jd01_15;

import by.it.kudelko.jd01_14.Util;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        createMatrix();
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
                out.append(line).append('\n');
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

    private static int[][] createMatrix() {
        int[][] array = new int[6][4];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = (int) (Math.random() * 32 - 16);
            }
        }
        return array;
    }
}
