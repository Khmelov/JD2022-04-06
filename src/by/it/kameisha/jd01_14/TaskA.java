package by.it.kameisha.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    public static final String USER_DIR = "user.dir";
    public static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    public static final String RESULT_TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        String pathBinaryFile = Util.getPath(TaskA.class, DATA_TASK_A_BIN);
        writeIntegers(pathBinaryFile);
        ArrayList<Integer> integers = readIntegers(pathBinaryFile);


    }

    private static void writeIntegers(String pathBinaryFile) {
        try (DataOutputStream dataOutputStream =
                     new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pathBinaryFile)))) {
            for (int i = 0; i < 20; i++) {
                int value = ThreadLocalRandom.current().nextInt(0, 1000);
                dataOutputStream.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> readIntegers(String pathBinaryFile) {
        ArrayList<Integer> integers = new ArrayList<>();
        try (DataInputStream dataInputStream =
                     new DataInputStream(new BufferedInputStream(new FileInputStream(pathBinaryFile)))) {
            while (dataInputStream.available() > 0) {
                integers.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return integers;
    }
}
