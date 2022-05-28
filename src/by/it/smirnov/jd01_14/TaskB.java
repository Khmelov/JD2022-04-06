package by.it.smirnov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static final String FILE_INP = "Poem.txt";

    private static final String FILE_RES = "resultTaskB.txt";
    private static int countWord = 0;
    private static int countPunct = 0;

    public static void main(String[] args) {
        textAnalizer();
        System.out.printf("words=%d, punctuation marks=%d", countWord, countPunct);
        writeToFile();
    }

    private static void textAnalizer() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TaskA.getDir(TaskB.class) + FILE_INP))) {
            String text = "";
            while ((text = reader.readLine()) != null) {
                //text = reader.readLine();
                counterWords(text);
                counterPunct(text);
            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void counterWords(String text) {
        Pattern patternW = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcherW = patternW.matcher(text);
        while (matcherW.find()) countWord++;
    }

    private static void counterPunct(String text) {
        Pattern patternP = Pattern.compile("(\\.\\.)?[\\p{P}]");
        Matcher matcherP = patternP.matcher(text);
        while (matcherP.find()) countPunct++;
    }

    private static void writeToFile() {
        try (PrintWriter writerTxt = new PrintWriter(new FileWriter(TaskA.getDir(TaskB.class) + FILE_RES))) {
            writerTxt.printf("words=%d, punctuation marks=%d", countWord, countPunct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
