package by.it.arsenihlaz.jd01_14;

import by.it._classwork_.jd01_14.Util;

import java.io.*;
import java.util.Scanner;

public class TaskB {
    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) {

        String pathFile = Util.getPath(TaskB.class, "Poem.txt");
        File poem = new File(pathFile);
        try {
            Scanner scanner = new Scanner(new FileInputStream(poem));
            scanner.useDelimiter("[^а-яА-ЯёЁ]+");
            while (scanner.hasNext()) {
                scanner.next();
                counter1++;
            }
            Scanner scanner2 = new Scanner(new FileInputStream(poem));
            while (scanner2.hasNext()) {
                String lineBefore = scanner2.nextLine();
                String lineAfter = lineBefore.replaceAll("[,!?;:-\\\\.{3}]", "");
                counter2 += lineBefore.length() - lineAfter.length();
            }
            System.out.println("words=" + counter1 + " marks=" + counter2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String txtFile = Util.getPath(TaskA.class, "resultTaskB.txt");
        try (PrintWriter out = new PrintWriter(txtFile)) {
            out.println("words=" + counter1 + " marks=" + counter2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
