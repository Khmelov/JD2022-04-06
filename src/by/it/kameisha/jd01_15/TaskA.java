package by.it.kameisha.jd01_15;

import by.it.kameisha.jd01_14.Util;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final int ROWS = 6;
    public static final int COLNS = 4;
    public static final int MIN_VALUE = -15;
    public static final int MAX_VALUE = 15;

    public static void main(String[] args) {
        String pathTxtFile = Util.getPath(TaskA.class,"matrix.txt");
        int[][] matrix = createMatrix();
        printMatrixInFile(pathTxtFile,matrix);
        String result = readFile(pathTxtFile);
        System.out.println(result);
    }

    private static String readFile(String pathTxtFile) {
        StringBuilder result = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(pathTxtFile))){
            while(reader.ready()){
                String line = reader.readLine();
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }

    private static void printMatrixInFile(String pathTxtFile, int[][] matrix) {
        try(PrintWriter printer = new PrintWriter(pathTxtFile)){
            for (int[] row : matrix) {
                for (int element : row) {
                    printer.printf("%3d ",element);
                }
                printer.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] createMatrix() {
        int[][]matrix = new int[TaskA.ROWS][TaskA.COLNS];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(TaskA.MIN_VALUE, TaskA.MAX_VALUE +1);
            }
        }
        return matrix;
    }
}
