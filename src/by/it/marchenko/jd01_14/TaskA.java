package by.it.marchenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    public static final String BIN_DATA_FILE = "dataTaskA.bin";
    private static final String TXT_DATA_FILE = "resultTaskA.txt";
    public static final int INTEGER_AMOUNT = 20;
    public static final int RANDOM_NUMBER_MIN = 0;
    public static final int RANDOM_NUMBER_MAX = 1000;
    public static final String SEPARATOR = " ";
    public static final String AVG_MESSAGE = "avg=";

    public static void main(String[] args) {
        String binFilePath = Util.getFilePath(BIN_DATA_FILE);
        writeBinFile(binFilePath);
        ArrayList<Integer> dataList = readBinFile(binFilePath);
        printDataToConsole(dataList);
        String txtFilePath = Util.getFilePath(TXT_DATA_FILE);
        printDataToFile(dataList, txtFilePath);
    }

    private static void writeBinFile(String binFilePath) {
        try (DataOutputStream binFileOutputStream =
                     new DataOutputStream(new BufferedOutputStream(new FileOutputStream(binFilePath)))) {
            for (int i = 0; i < INTEGER_AMOUNT; i++) {
                binFileOutputStream.writeInt(ThreadLocalRandom.current().nextInt(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> readBinFile(String binFilePath) {
        ArrayList<Integer> dataList = new ArrayList<>(INTEGER_AMOUNT);
        try (DataInputStream dataFileInputStream =
                     new DataInputStream(new BufferedInputStream(new FileInputStream(binFilePath)))) {
            while (dataFileInputStream.available() > 0) {
                dataList.add(dataFileInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }

    private static void printDataToConsole(ArrayList<Integer> dataList) {
        double sum = 0;
        for (Integer integer : dataList) {
            System.out.printf("%d%s", integer, SEPARATOR);
            sum += integer;
        }
        System.out.println("\n" + AVG_MESSAGE + sum / dataList.size());
    }

    private static void printDataToFile(ArrayList<Integer> dataList, String filePath) {
        double sum = 0;
        try (PrintWriter out = new PrintWriter(filePath)) {
            for (Integer integer : dataList) {
                out.print(integer + SEPARATOR);
                sum += integer;
            }
            out.println("\n" + AVG_MESSAGE + sum / dataList.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
