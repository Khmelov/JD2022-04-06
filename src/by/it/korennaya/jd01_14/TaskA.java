package by.it.korennaya.jd01_14;

import by.it._classwork_.jd01_14.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    public static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    public static final String RESULT_TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        String pathBinaryFile = Util.getPath(TaskA.class, DATA_TASK_A_BIN);
        writeIntegers(pathBinaryFile);
        ArrayList<Integer> integers = readIntegers(pathBinaryFile);
        printToConsole(integers);
        String pathTxtFile = Util.getPath(TaskA.class, RESULT_TASK_A_TXT);
        printToTxtFile(integers, pathTxtFile);
    }

    private static void printToTxtFile(ArrayList<Integer> integers, String txtFile) {
        try(PrintWriter fout = new PrintWriter(txtFile)) {
            double sumOut = 0;
            for (Integer integer: integers) {
                fout.print(integer + " ");
                sumOut += integer;
            }
            fout.println("\navg=" + sumOut/ integers.size());
        } catch (IOException exception) {
            throw new RuntimeException();
        }
    }

    private static void printToConsole(ArrayList<Integer> integers) {
        double sum = 0;
        for (Integer integer: integers) {
            System.out.print(integer + " ");
            sum += integer;
        }
        System.out.println("\navg=" + sum/ integers.size());
    }

    private static ArrayList<Integer> readIntegers(String path) {
        ArrayList<Integer> integers = new ArrayList<>();
        try (
                DataInputStream dataInputStream =
                        new DataInputStream(new BufferedInputStream(new FileInputStream(path)))
        ) {
            while (dataInputStream.available()>0) {
                integers.add(dataInputStream.readInt());
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return integers;
    }

    private static void writeIntegers(String path) {
        try (
                DataOutputStream dataOutputStream =
                        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))
        ) {
            for (int i = 0; i < 20; i++) {
                int random = ThreadLocalRandom.current().nextInt(0, 100);
                dataOutputStream.writeInt(random);
            }
        } catch (IOException exception) {
            throw new RuntimeException();
        }
    }
}