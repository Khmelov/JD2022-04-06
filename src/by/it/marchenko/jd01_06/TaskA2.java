package by.it.marchenko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static final String RUSSIAN_WORD_PATTERN = "[а-яА-яёЁ]+";
    private static String[] words = {};
    private static int[] wordsRepeating = {};


    public static void main(String[] args) {
        Pattern russianWords = Pattern.compile(RUSSIAN_WORD_PATTERN);
        String textForAnalyse = Poem.text;
        Matcher wordFounded = russianWords.matcher(textForAnalyse);

        while (wordFounded.find()) {
            String word = wordFounded.group();
            countWordRepeating(word);
        }
        printWordsRepeating();
    }

    private static void countWordRepeating(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                wordsRepeating[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
        wordsRepeating = Arrays.copyOf(wordsRepeating, wordsRepeating.length + 1);
        wordsRepeating[wordsRepeating.length - 1] = 1;
    }

    private static void printWordsRepeating() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n", words[i], wordsRepeating[i]);
        }
    }
}
