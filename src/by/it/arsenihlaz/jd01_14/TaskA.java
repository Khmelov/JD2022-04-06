package by.it.arsenihlaz.jd01_14;

import by.it._classwork_.jd01_14.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA {
    public static void main(String[] args) {
        String pathFile = Util.getPath(TaskA.class, "dataTaskA.bin");
        try (DataOutputStream dataOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(pathFile)))
        ) {
            for (int i = 0; i < 20; i++) {
                int value = ThreadLocalRandom.current().nextInt(0, 255);
                dataOut.writeInt(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        try (DataInputStream dataIn = new DataInputStream(new BufferedInputStream(new FileInputStream(pathFile)));
        ) {
            while (dataIn.available() > 0) {
                integers.add(dataIn.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        double sum = 0;
        for (int i = 0; i < integers.size(); i++) {
            sum += integers.get(i);
            System.out.print(integers.get(i) + " ");
        }
        System.out.println("\navg=" + sum / integers.size());

        String txtFile = Util.getPath(TaskA.class, "resultTaskA.txt");

        try (PrintWriter out = new PrintWriter(txtFile)) {
            double sum2 = 0;
            for (int i = 0; i < integers.size(); i++) {
                sum2 += integers.get(i);
               out.print(integers.get(i) + " ");
            }
            out.println("\navg=" + sum2 / integers.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}