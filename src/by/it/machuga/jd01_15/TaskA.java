package by.it.machuga.jd01_15;

import by.it.machuga.jd01_14.Util;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final int ROWS = 6;
    public static final int COLS = 4;
    public static final int MAX_VALUE = 15;
    public static final int MIN_VALUE = -15;
    public static final String FILE_NAME = "matrix.txt";
    public static final String MESSAGE_IO_ERROR = "io error";
    public static final String PRINT_FORMAT = "%3d ";

    public static void main(String[] args) {
        int[][] matrix = createMatrix(ROWS, COLS, MIN_VALUE, MAX_VALUE);
        String fileName = Util.getPath(TaskA.class, FILE_NAME);
        printMatrix(matrix, fileName);
        String text = readFile(fileName);
        System.out.println(text);

    }

    private static String readFile(String fileName) {
        StringBuilder out=new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                 String line = reader.readLine();
                 out.append(line).append('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(MESSAGE_IO_ERROR, e);
        }
        return out.toString();
    }

    private static void printMatrix(int[][] matrix, String fileName) {
        try (PrintWriter out
                     = new PrintWriter(fileName)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    out.printf(PRINT_FORMAT, element);
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(MESSAGE_IO_ERROR, e);
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
