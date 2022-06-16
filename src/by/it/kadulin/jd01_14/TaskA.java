package by.it.kadulin.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {

    public static final String USER_DIR = "user.dir";

    public static void main(String[] args) {
        String path = Util.getPath(TaskA.class, "dataTaskA.bin");
        System.out.println(path);
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
            for (int i = 0; i < 20; i++) {
                int value = ThreadLocalRandom.current().nextInt(0, 20);
                dos.write(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Integer> list = new ArrayList<>();
        try (DataInputStream das = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            while (das.available() > 0) {
                list.add(das.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String result = Util.getPath(TaskA.class,"resultTaskA.txt");
        try (PrintWriter pw = new PrintWriter(result)) {
            double sum = 0;
            for (Integer integer : list) {
                sum = sum + integer;
                System.out.print(integer + " ");
            }
            System.out.println();
            System.out.println("avg=" + sum / list.size());
            pw.write("avg=" + sum / list.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
