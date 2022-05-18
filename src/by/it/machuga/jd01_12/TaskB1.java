package by.it.machuga.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    static Scanner scanner;
    public static final String DELIMITER = " ";
    public static final String END = "end";
    public static final String REGEX = "[a-zA-Z']+";

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        String text = getText();

        Map<String, Integer> words = new HashMap<>();
        countWords(text, words);

        printCounts(words);
    }

    private static String getText() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        while (scanner.hasNext()) {
            String value = scanner.next();
            if (!value.equals(END)) {
                stringJoiner.add(value);
            } else {
                break;
            }
        }
        String text = stringJoiner.toString();
        System.out.println(text);
        return text;
    }

    private static void countWords(String text, Map<String, Integer> words) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (words.keySet().contains(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }
    }

    private static void printCounts(Map<String, Integer> words) {
        for (Map.Entry<String, Integer> pair : words.entrySet()) {
            System.out.printf("%s=%d%n", pair.getKey(), pair.getValue());
        }
    }
}
