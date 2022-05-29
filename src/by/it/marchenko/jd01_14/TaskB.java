package by.it.marchenko.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static final String DATA_FILE_NAME = "Poem.txt";
    public static final String RESULT_FILE_NAME = "resultTaskB.txt";
    public static final String RUSSIAN_WORD_PATTERN = "[А-Яа-яЁё]+";
    public static final String PUNCTUATIONS_PATTERN = "[-!?,:+]|(\\.{1,3})";

    public static void main(String[] args) {
        String dataFilePath = Util.getFilePath(DATA_FILE_NAME);
        String dataText = getDataText(dataFilePath);

        int wordsCount = countMatch(dataText, RUSSIAN_WORD_PATTERN);
        int punctuationCount = countMatch(dataText, PUNCTUATIONS_PATTERN);

        printResult(wordsCount, punctuationCount);

        String resultFilePath = Util.getFilePath(RESULT_FILE_NAME);
        printResult(resultFilePath, wordsCount, punctuationCount);
    }

    private static String getDataText(String dataFilePath) {
        StringBuilder dataText = new StringBuilder();
        try (FileReader fileReader = new FileReader(dataFilePath)) {
            while (fileReader.ready()) {
                char c = (char) fileReader.read();
                dataText.append(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataText.toString();
    }

    private static int countMatch(String text, String regexp) {
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(text);
        int counts = 0;
        while (matcher.find()) {
            counts++;
        }
        return counts;
    }

    private static void printResult(int wordsCount, int punctuationCount) {
        System.out.printf("%s=%d, %s=%d%n",
                "words", wordsCount,
                "punctuations marks", punctuationCount);
    }

    private static void printResult(String filePath, int wordsCount, int punctuationCount) {
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.printf("%s=%d, %s=%d%n",
                    "words", wordsCount,
                    "punctuations marks", punctuationCount);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
