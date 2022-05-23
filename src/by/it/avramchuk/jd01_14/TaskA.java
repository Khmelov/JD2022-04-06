package by.it.avramchuk.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String USER_DIR = "user.dir";
    public static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    public static final String RESULT_TASK_A_TXT = "resultTaskA.txt";

    public static void main(String[] args) {

        String binaryFile = Util.getPath(TaskA.class, DATA_TASK_A_BIN);
        writeIntegers(binaryFile);
        ArrayList<Integer> integers = readIntegers(binaryFile);
        printConsole(integers);
        String txtFile = Util.getPath(TaskA.class, RESULT_TASK_A_TXT);
        printTxtFile(integers, txtFile);

    }

    private static void writeIntegers(String path) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(new FileOutputStream(path)))
        ){
            for (int i = 0; i < 20; i++) {
                int value = ThreadLocalRandom.current().nextInt(1, 1000);
                dataOutputStream.writeInt(value);
            }
        } catch (IOException e) {
            throw   new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> readIntegers(String path) {
        ArrayList<Integer> integers = new ArrayList<>();
        try (
                DataInputStream dataInputStream = new DataInputStream(
                        new BufferedInputStream(new FileInputStream(path)))
        ) {
            while (dataInputStream.available()>0){
                integers.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return integers;
    }

    private static void printConsole(ArrayList<Integer> integers) {
        double sum=0;
        for (Integer integer : integers) {
            sum+=integer;
            System.out.print(integer+" ");
        }
        System.out.println("\navg="+sum/ integers.size());
    }

    private static void printTxtFile(ArrayList<Integer> integers, String txtFile) {
        try(PrintWriter out = new PrintWriter(txtFile)){
            double sum2=0;
            for (Integer integer : integers) {
                sum2+=integer;
                out.print(integer+" ");
            }
            out.println("\navg="+sum2/ integers.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
