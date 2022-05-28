package by.it.avramchuk.jd01_15;

import by.it.avramchuk.jd01_14.Util;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final int ROWS = 6;
    public static final int COLS = 4;
    public static final int MIN_VALUE = -15;
    public static final int MAX_VALUE = 15;

    public static void main(String[] args) {
        int[][] matrix = createMatrix(ROWS, COLS, MIN_VALUE, MAX_VALUE);
        String path = Util.getPath(TaskA.class, "matrix.txt");
        printMatrix(matrix, path);
        String text = readFile(path);
        System.out.println(text);
    }

    private static String readFile(String path) {
        StringBuilder out = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            while(reader.ready()){
                String s = reader.readLine();
                out.append(s).append('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException("io error", e);
        }
        return out.toString();
    }

    private static void printMatrix(int[][] matrix, String path) {
        try(PrintWriter out = new PrintWriter(path)){
            for (int[] row : matrix) {
                for (int element : row) {
                    out.printf("%3d ",element);
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
                matrix[i][j]= ThreadLocalRandom.current().nextInt(minValue, maxValue+1);
            }
        }
        return matrix;

    }
}
