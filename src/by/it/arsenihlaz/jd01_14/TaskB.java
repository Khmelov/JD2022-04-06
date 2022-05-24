package by.it.arsenihlaz.jd01_14;

import java.io.*;
import java.util.Scanner;

public class TaskB implements Constant {

    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) {
        counterTextConsole();
        counterTextFile();
    }

    private static void counterTextConsole() {
        String pathFile = Util.getPath(TaskB.class, POEM_TXT);
        File poem = new File(pathFile);
        try (Scanner scanner = new Scanner(new FileInputStream(poem))) {
            scanner.useDelimiter(DELIMITER);
            while (scanner.hasNext()) {
                scanner.next();
                counter1++;
            }
            Scanner scanner2 = new Scanner(new FileInputStream(poem));
            while (scanner2.hasNext()) {
                String lineBefore = scanner2.nextLine();
                String lineAfter = lineBefore.replaceAll(REGEX_PUNCTUATION, REPLACEMENT);
                counter2 += lineBefore.length() - lineAfter.length();
            }
            System.out.println(WORDS + counter1 + MARKS + counter2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void counterTextFile() {
        String txtFile = Util.getPath(TaskB.class, RESULT_TASK_B_TXT);
        try (PrintWriter out = new PrintWriter(txtFile)) {
            out.println(WORDS + counter1 + MARKS + counter2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
