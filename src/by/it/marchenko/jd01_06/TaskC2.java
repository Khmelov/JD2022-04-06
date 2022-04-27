package by.it.marchenko.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    private static final String RUS_WORD_PATTERN = "[а-яА-ЯёЁ]+";
    private static final String SEPARATOR = " ";
    private static final int REQUIRED_LENGTH = 100000;
    private static String[] words = {};
    private static final long SEED = 1034531413;


    public static void main(String[] args) {
        String inputText = Poem.text;

        long slowStart = System.nanoTime();
        String slowString = slow(inputText);
        long slowFinish = System.nanoTime();
        long slowTime = slowFinish - slowStart;
        System.out.println(slowString);
        System.out.println(slowTime);

        long fastStart = System.nanoTime();
        String fastString = fast(inputText);
        long fastFinish = System.nanoTime();
        long fastTime = fastFinish - fastStart;
        System.out.println(fastString);
        System.out.println(fastTime);
    }

    private static String[] createWordsPull(String text) {
        Pattern wordsPattern = Pattern.compile(RUS_WORD_PATTERN);
        Matcher wordsMatcher = wordsPattern.matcher(text);
        while (wordsMatcher.find()) {
            String word = wordsMatcher.group();
            addWordToPull(word);
        }
        return words;
    }

    private static void addWordToPull(String word) {
        for (String oneWord : words) {
            if (word.equals(oneWord)) {
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
    }

    private static String slow(String text) {
        String[] words = createWordsPull(text);
        String line = "";

        Random randomSlow = new Random(SEED);
        while (REQUIRED_LENGTH > line.length()) {
            String wordToSlowAdd = words[randomSlow.nextInt(words.length)];
            line = line.concat(wordToSlowAdd);
            if (line.length() < REQUIRED_LENGTH) {
                line = line.concat(SEPARATOR);
            }
        }
        return line;
    }

    private static String fast(String text) {
        String[] words = createWordsPull(text);
        StringBuilder fastLine = new StringBuilder();


        Random randomFast = new Random(SEED);
        while (REQUIRED_LENGTH > fastLine.length()) {
            String wordToFastAdd = words[randomFast.nextInt(words.length)];
            fastLine.append(wordToFastAdd);
            if (fastLine.length() < REQUIRED_LENGTH) {
                fastLine.append(SEPARATOR);
            }
        }
        return fastLine.toString();

    }
}
