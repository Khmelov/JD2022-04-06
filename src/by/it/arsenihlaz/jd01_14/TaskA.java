package by.it.arsenihlaz.jd01_14;

import by.it._classwork_.jd01_14.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String PATH_BINFILE_NAME = "dataTaskA.bin";
    public static final String PATH_TXTFILE_NAME = "resultTaskA.txt";

    public static void main(String[] args) {
        String pathBinFile = Util.getPath(TaskA.class, PATH_BINFILE_NAME);
        writeIntegers(pathBinFile);
        ArrayList<Integer> integers = readIntegers(pathBinFile);
        printConsole(integers);
        String txtFile = Util.getPath(TaskA.class, PATH_TXTFILE_NAME);
        printTxtFile(integers, txtFile);
    }


    private static void writeIntegers(String pathFile) {
        try (DataOutputStream dataOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pathFile)))
        ) {
            for (int i = 0; i < 20; i++) {
                int value = ThreadLocalRandom.current().nextInt(0, 255);
                dataOut.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> readIntegers(String pathFile) {
        ArrayList<Integer> integers = new ArrayList<>();
        try (DataInputStream dataIn = new DataInputStream(new BufferedInputStream(new FileInputStream(pathFile)))
        ) {
            while (dataIn.available() > 0) {
                integers.add(dataIn.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return integers;
    }

    private static void printConsole(ArrayList<Integer> integers) {
        double sum = 0;
        for (Integer integer : integers) {
            sum += integer;
            System.out.print(integer + " ");
        }
        System.out.println("\navg=" + sum / integers.size());
    }

    private static void printTxtFile(ArrayList<Integer> integers, String txtFile) {
        try (PrintWriter out = new PrintWriter(txtFile)) {
            double sum2 = 0;
            for (Integer integer : integers) {
                sum2 += integer;
                out.print(integer + " ");
            }
            out.println("\navg=" + sum2 / integers.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}