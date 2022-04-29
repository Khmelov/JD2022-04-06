package by.it.kudelko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String[] words = {};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }
        printResult();

    }

    private static void process(String word) {
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
    }

    private static void printResult() {
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }
}

