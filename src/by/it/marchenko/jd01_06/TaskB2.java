package by.it.marchenko.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    private static final String SENTENCE_PATTERN = "[^.!?]+";
    private static final String NON_RUS_LETTER_PATTERN = "[^а-яА-ЯёЁ]+";
    private static final String SYMBOL_TO_REPLACE = " ";

    public static void main(String[] args) {

        String[] sentences = getSentences();
        Arrays.sort(sentences, LengthComparator);
        printSentences(sentences);
    }

    private static String[] getSentences() {
        String text = changeMultiSymbol();
        Pattern sentencePattern = Pattern.compile(SENTENCE_PATTERN);
        Pattern nonLetterSymbolPattern = Pattern.compile(NON_RUS_LETTER_PATTERN);

        Matcher sentencesMatcher = sentencePattern.matcher(text);
        String[] sentences = {};
        int sentenceIndex = 0;
        while (sentencesMatcher.find()) {
            sentences = Arrays.copyOf(sentences, sentences.length + 1);
            String sentence = sentencesMatcher.group();
            Matcher sentenceFormat = nonLetterSymbolPattern.matcher(sentence);
            sentence = sentenceFormat.replaceAll(SYMBOL_TO_REPLACE);
            sentences[sentenceIndex++] = sentence.trim();
        }
        return sentences;
    }

    public static Comparator<String> LengthComparator = Comparator.comparingInt(String::length);

    private static void printSentences(String[] sentences) {
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

    private static String changeMultiSymbol() {
        final String MULTI_SYMBOL = "(\\.{3})(\\s)+";
        final String BIG_RUS_LETTER = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ>";
        StringBuilder correctedText = new StringBuilder(Poem.text);
        Pattern multiSymbolPattern = Pattern.compile(MULTI_SYMBOL);
        Matcher multiSymbolMatcher = multiSymbolPattern.matcher(correctedText);
        while (multiSymbolMatcher.find()) {
            char firstLetter = correctedText.charAt(multiSymbolMatcher.end());
            if (BIG_RUS_LETTER.indexOf(firstLetter) < 0) {
                int correctedLength = multiSymbolMatcher.end() - multiSymbolMatcher.start();
                //correctedText =
                        correctedText.replace
                        (multiSymbolMatcher.start(), multiSymbolMatcher.end() - 1,
                                SYMBOL_TO_REPLACE.repeat(correctedLength));
            }
        }
        return correctedText.toString();
    }


}
