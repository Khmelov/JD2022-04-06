package by.it.ragach.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
;

public class TaskB {

    private static String regex = "[а-яА-ЯёЁ]+";
    private static String punctuation = "[-,?!:+]|(\\.{1,3})";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";

    public static void main(String[] args) {


        String pathForTextFile = Util.getPath(TaskB.class, "Poem.txt");
        String getText = getText(pathForTextFile);
        System.out.println(getText);
        int wordsCount = countsWordsInText(getText, regex);
        int marksCount = countsMarksInText(getText, punctuation);
        printToConsole(wordsCount, marksCount);
        String newTxtFile = Util.getPath(TaskB.class, RESULT_TASK_B_TXT);
        printToTxtFile(wordsCount, marksCount, newTxtFile);


    }

    private static void printToTxtFile(int wordsCount, int marksCount, String newTxtFile) {
        try (PrintWriter out = new PrintWriter(newTxtFile)) {
            out.println("words=" + wordsCount + "," + "punctuation marks=" + marksCount);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static int countsWordsInText(String getText, String regex) {
        int count = 0;
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(getText);
            while (matcher.find()) {
                count++;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    private static int countsMarksInText(String getText, String s) {
        int count2 = 0;
        try {
            Pattern pattern = Pattern.compile("[-,?!:+]|(\\.{1,3})");
            Matcher matcher = pattern.matcher(getText);
            while (matcher.find()) {
                count2++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count2;
    }

    private static void printToConsole(int wordsCount, int marksCount) {
        System.out.println("words=" + wordsCount + "," + "punctuation marks=" + marksCount);

    }

    private static String getText(String pathForTextFile) {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(pathForTextFile)) {
            while (fileReader.ready()) {
                char t = (char) fileReader.read();
                sb.append(t);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}


