package by.it.marchenko.jd01_15;

import java.io.*;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    public static final int ROWS = 6;
    public static final int COLS = 4;
    public static final int MIN_VALUE = -15;
    public static final int MAX_VALUE = 15;
    public static final String FILE_NAME = "matrix.txt";
    public static final String FILE_EXCEPTION_MESSAGE = "File not found";
    public static final String DELIMITER = "\n";
    public static final String FORMAT = "%3s ";

    public static void main(String[] args) {
        int[][] matrix = createMatrix(ROWS, COLS, MIN_VALUE, MAX_VALUE);
        String fileName = Util.getFilePath(FILE_NAME);
        saveMatrixToFile(fileName, matrix);
        String text = readDataFromFile(fileName);
        System.out.println(text);
    }

    @SuppressWarnings("SameParameterValue")
    private static int[][] createMatrix(int rows, int cols, int minValue, int maxValue) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
            }
        }
        return matrix;
    }

    private static void saveMatrixToFile(String fileName, int[][] matrix) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    out.printf(FORMAT, element);
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(FILE_EXCEPTION_MESSAGE, e);
        }
    }

    private static String readDataFromFile(String fileName) {
        StringJoiner text = new StringJoiner(DELIMITER);
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                String line = in.readLine();
                if (!Objects.isNull(line)) {
                    text.add(line);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(FILE_EXCEPTION_MESSAGE, e);
        }
        return text.toString();
    }
}
