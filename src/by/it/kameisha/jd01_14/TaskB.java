package by.it.kameisha.jd01_14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static final String POEM_TEXT = "Poem.txt";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";
    public static final String RUSSIAN_WORDS = "[а-яА-ЯёЁ]+";
    public static final String PUNCTUATION_MARKS = "[,.:;!?]";

    public static void main(String[] args) {
        String pathPoemText = Util.getPath(TaskB.class, POEM_TEXT);
        String pathResultTaskBText = Util.getPath(TaskB.class, RESULT_TASK_B_TXT);
        printWordsAndPunctuationMarksCounts(pathPoemText);
    }

    private static void printWordsAndPunctuationMarksCounts(String path) {
        Pattern patternWords = Pattern.compile(RUSSIAN_WORDS);
        Pattern patternPunctuationMarks = Pattern.compile(PUNCTUATION_MARKS);
        int countWords = 0;
        int countPunctuationMarks = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while (null != (line = bufferedReader.readLine())) {
                Matcher matcherWords = patternWords.matcher(line);
                Matcher matcherPunctuationMarks = patternPunctuationMarks.matcher(line);
                while (matcherWords.find()) {
                    countWords++;
                }
                while (matcherPunctuationMarks.find()) {
                    countPunctuationMarks++;
                }
            }
            System.out.println("words=" + countWords + ", punctuation marks=" + countPunctuationMarks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
