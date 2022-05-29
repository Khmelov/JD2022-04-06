package by.it.kudelko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String USER_DIR = "user.dir";
    public static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    public static final String RESULT_TASK_A_TXT = "resultTaskA.txt";

    public TaskA() {
    }

    public static void main(String[] args) {
        String pathBinaryFile = Util.getPath(TaskA.class, DATA_TASK_A_BIN);
        writeIntegers(pathBinaryFile);
        ArrayList<Integer> integers = readIntegers(pathBinaryFile);
        printToConsole(integers);
        String pathTxtFile = Util.getPath(TaskA.class, RESULT_TASK_A_TXT);
        printToTxtFile(integers, pathTxtFile);
    }

    private static void writeIntegers(String path) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(path)
                        )
                )
        ) {
            for (int i = 0; i < 20; i++) {
                int value = ThreadLocalRandom.current().nextInt(0, 1000);
                dataOutputStream.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> readIntegers(String path) {
        ArrayList<Integer> integers = new ArrayList<>();
        try (
                DataInputStream dataInputStream = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(path)
                        )
                )
        ) {
            while (dataInputStream.available() > 0) {
                integers.add(dataInputStream.readInt());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return integers;
    }

    private static void printToConsole(ArrayList<Integer> integers) {
        double sum = 0;
        double count = 0;
        for (Integer integer : integers) {
            sum = sum + integer;
            count++;
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("avg=" + sum / count);
    }

    private static void printToTxtFile(ArrayList<Integer> integers, String txtFile) {
        try (PrintWriter out = new PrintWriter(txtFile)) {
            double sum2 = 0;
            double count2 = 0;
            for (Integer integer : integers) {
                sum2 = sum2 + integer;
                count2++;
                out.print(integer + " ");
            }
            System.out.println();
            System.out.println("avg=" + sum2 / count2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
