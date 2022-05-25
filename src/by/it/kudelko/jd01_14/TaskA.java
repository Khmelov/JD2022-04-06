package by.it.kudelko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String USER_DIR = "user.dir";

    public TaskA() {
    }

    public static void main(String[] args) {
        String path = Util.getPath(TaskA.class, "dataTaskA.bin");
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
        double sum = 0;
        double count = 0;
        for (Integer integer : integers) {
            sum = sum + integer;
            count++;
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("avg=" + sum / count);

        String txtFile = Util.getPath(TaskA.class, "resultTaskA.txt");
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
