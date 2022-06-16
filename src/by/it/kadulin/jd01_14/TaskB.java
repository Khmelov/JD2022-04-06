package by.it.kadulin.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String PUNCTUATIONS = "[-,.!:]{1,3}";
    public static final String WORDS = "[А-Яа-яЁё]+";

    private static int punctuationMark = 0;
    private static int words = 0;

    public static void main(String[] args) {
        String poem = Util.getPath(TaskB.class, "Poem.txt");
        readPoem(poem);
        String result = String.format("words=%d, punctuation marks=%d", words, punctuationMark);
        System.out.println(result);
        writeResult(result);
    }

    private static void writeResult(String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Util.getPath(TaskB.class, "resultTaskB.txt")))) {
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readPoem(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String s = reader.readLine();
                Pattern compileWords = Pattern.compile(WORDS);
                Matcher matcherWords = compileWords.matcher(s);
                while (matcherWords.find()) {
                    words++;
                }
                Pattern compilePunctuations = Pattern.compile(PUNCTUATIONS);
                Matcher matcherPunctuations = compilePunctuations.matcher(s);
                while (matcherPunctuations.find()) {
                    punctuationMark++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
