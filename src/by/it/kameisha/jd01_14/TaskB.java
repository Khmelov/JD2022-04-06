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
        Pattern patternWords = Pattern.compile(RUSSIAN_WORDS);
        Pattern patternPunctuationMarks = Pattern.compile(PUNCTUATION_MARKS);
        int countWords = checkPatternCount(patternWords, pathPoemText);
        int countPunctuationMarks = checkPatternCount(patternPunctuationMarks, pathPoemText);
        System.out.println("words="+countWords + ", punctuation marks=" + countPunctuationMarks);
    }

    private static int checkPatternCount(Pattern pattern, String filePath) {
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while (null != (line = bufferedReader.readLine())) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
