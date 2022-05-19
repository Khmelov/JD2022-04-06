package by.it.marchenko.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static final String ENGLISH_WORD_PATTERN = "[A-Za-z']+";
    public static final String INPUT_END = "end";
    private static final Map<String, Integer> wordMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Pattern englishWordPattern = Pattern.compile(ENGLISH_WORD_PATTERN);
        boolean isInputEnd = false;
        while (!isInputEnd) {
            String line = console.nextLine();
            Matcher englishWordMatcher = englishWordPattern.matcher(line);
            while (englishWordMatcher.find()) {
                String word = englishWordMatcher.group();
                if (!INPUT_END.equals(word)) {
                    if (word.matches(ENGLISH_WORD_PATTERN)) {
                        if (wordMap.containsKey(word)) {
                            wordMap.replace(word, wordMap.get(word) + 1);
                        } else {
                            wordMap.put(word, 1);
                        }
                    }
                } else {
                    isInputEnd = true;
                    break;
                }
            }
        }
        printWordAppearance();
    }

    private static void printWordAppearance() {
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.printf("%s=%d%n", entry.getKey(), entry.getValue());
        }
    }
}
