package by.it.smirnov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static final String FILE_BIN = "dataTaskA.bin";
    private static final String FILE_TXT = "resultTaskA.txt";
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        input();
        output();
    }

    private static void input() {
        try (DataOutputStream writer = new DataOutputStream(new BufferedOutputStream
                (new FileOutputStream(getDir(TaskA.class) + FILE_BIN)))) {
            for (int i = 0; i < 20; i++) {
                writer.writeInt((int) ((Math.random() * 100)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void output() {
        try (DataInputStream reader = new DataInputStream(new BufferedInputStream(new FileInputStream(getDir(TaskA.class) + FILE_BIN)));
             PrintWriter writerTxt = new PrintWriter(new FileWriter(getDir(TaskA.class) + FILE_TXT))) {
            double sum = 0;
            double count = 0;
            while (reader.available() > 0) {
                int i = reader.readInt();
                list.add(i);
                System.out.print(i + " ");
                writerTxt.print(i + " ");
                sum += i;
                count++;
            }
            System.out.println("\navg=" + sum / count);
            writerTxt.println("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDir(Class<?> cl) {
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + clDir;
        return path;
    }
}
