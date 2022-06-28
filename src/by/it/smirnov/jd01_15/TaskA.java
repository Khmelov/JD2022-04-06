package by.it.smirnov.jd01_15;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    private static final String FILE_RES = "matrix.txt";
    private static final int RAWS = 6;
    private static final int COLS = 4;
    private static final int RAND_MIN = -15;
    private static final int RAND_MAX = 15;

    public static void main(String[] args) {
        int[][] matrix = createMatrix(RAWS, COLS, RAND_MIN, RAND_MAX);
        String filePath = getDir(TaskA.class) + FILE_RES;
        writeToFile(matrix, filePath);
        showInConsole(filePath);
    }

    private static void showInConsole(String filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) System.out.println(reader.readLine());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] createMatrix(int rows, int cols, int min, int max) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(min, max);
            }
        }
        return matrix;
    }

    public static String getDir(Class<?> cl) {
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + clDir;
    }

    private static void writeToFile(int[][] matrix, String filePath) {
        try (PrintWriter writerTxt = new PrintWriter(filePath)) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    writerTxt.printf("%3d ", anInt);
                }
                writerTxt.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
