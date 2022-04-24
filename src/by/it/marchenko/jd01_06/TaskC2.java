package by.it.marchenko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    private static final String RUS_WORD_PATTERN = "[а-яА-ЯёЁ]+";
    private static final String SEPARATOR = " ";
    private static final int length = 100*2;
    private static String[] words = {};


    public static void main(String[] args) {
        String[] words = createWordsPull(Poem.text);
        String sequence = getRandomWordSequence(words, length);
        long slowStart = System.nanoTime();
        String slowString = slow(sequence);
        long slowFinish = System.nanoTime();
        long slowTime = slowFinish - slowStart;
        System.out.println(slowString);
        System.out.println(slowTime);
        long fastStart = System.nanoTime();
        String fastString = fast(sequence);
        long fastFinish = System.nanoTime();
        long fastTime = fastFinish - fastStart;
        System.out.println(fastString);
        System.out.println(fastTime);
        System.out.println(slowString.equals(fastString));
        System.out.println(slowString.length());

        System.out.printf("Slow/Fast: %4.2f%n", (double)slowTime/fastTime);

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

    private static String getRandomWordSequence(String[] words, int length) {
        StringBuilder sequence = new StringBuilder();
        int maxWordIndex = words.length;
        int currentLength = sequence.length();
        while (length > currentLength - 1) {
            int currentWordIndex = (int) (Math.random() * maxWordIndex);
            sequence.append(currentWordIndex);
            sequence.append(SEPARATOR);
            currentLength += words[currentWordIndex].length() + 1;

        }
        return sequence.toString();
    }

    private static String slow(String sequence) {
        String line = "";
        String[] sequenceArray = sequence.split(SEPARATOR);
        for (int i = 0; i < sequenceArray.length; i++) {
            int wordPullIndex = Integer.parseInt(sequenceArray[i]);
            line = line.concat(words[wordPullIndex]);
            if (i != sequenceArray.length - 1) {
                line = line.concat(SEPARATOR);
            }
        }
        //System.out.println("Slow: "+ line.length());
        return line;
    }

    private static String fast(String sequence) {
        StringBuilder fastLine = new StringBuilder();
        String[] sequenceArray = sequence.split(SEPARATOR);
        for (int i = 0; i < sequenceArray.length; i++) {
            int wordPullIndex = Integer.parseInt(sequenceArray[i]);
            fastLine.append(words[wordPullIndex]);
            if (i != sequenceArray.length - 1) {
                fastLine.append(SEPARATOR);
            }
        }
        //System.out.println("Fast: "+ fastLine.length());
        return fastLine.toString();

    }
}
