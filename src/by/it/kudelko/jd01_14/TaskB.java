package by.it.kudelko.jd01_14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB {

    public static final String DELIMETER = "[^а-яА-ЯёЁ]+";
    public static final String FILENAME = "Poem.txt";
    public static final String PUNCTUATION_MARKS = "[,!?;:-\\\\.{3}]";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";
    private static int counterWords = 0;
    private static int counterPunctuationMarks = 0;

    public static void main(String[] args) {
        counterText();
        printFileText();
    }

    private static void counterText() {
        String pathFile = Util.getPath(TaskB.class, FILENAME);
        File poem = new File((pathFile));
        try (Scanner scannerWords = new Scanner(new FileInputStream(poem))) {
            scannerWords.useDelimiter(DELIMETER);
            while ((scannerWords.hasNext())) {
                scannerWords.next();
                counterWords++;
            }
            Scanner scannerPunctuationMarks = new Scanner(new FileInputStream(poem));
            while (scannerPunctuationMarks.hasNext()) {
                String lineBefore = scannerPunctuationMarks.nextLine();
                String lineAfter = lineBefore.replaceAll(PUNCTUATION_MARKS, "");
                counterPunctuationMarks += lineBefore.length() - lineAfter.length();
            }
            System.out.println("words=" + counterWords + ", punctuation marks=" + counterPunctuationMarks);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFileText() {
        String txtFile = Util.getPath(TaskB.class, RESULT_TASK_B_TXT);
        try (PrintWriter out = new PrintWriter(txtFile)){
            out.println("words=" + counterWords + ", punctuation marks=" + counterPunctuationMarks);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
