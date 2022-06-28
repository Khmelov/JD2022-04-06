package by.it.edeborg.jd01_15;

import by.it.arsenihlaz.jd01_14.Util;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = createMatrix(6, 4, -15, 15);
        String txtFile = Util.getPath(TaskA.class, "matrix.txt");
        printTxt(matrix, txtFile);
        String text = readFile(txtFile);
        System.out.println(text);
    }

    private static int[][] createMatrix(int rows, int columns, int minValue, int maxValue) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
            }
        }
        return matrix;
    }

    private static void printTxt(int[][] matrix, String txtFile) {
        try (PrintWriter out = new PrintWriter(txtFile)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int value = matrix[i][j];
                    out.printf("%3d ", value);
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("io error", e);
        }
    }

    private static String readFile(String txtFile) {
        StringBuilder out = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(txtFile))) {
            while (reader.ready()){
                String line = reader.readLine();
                out.append(line).append('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException("io error", e);
        }
        return out.toString();
    }
}
