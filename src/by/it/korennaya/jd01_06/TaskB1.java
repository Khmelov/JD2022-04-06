package by.it.korennaya.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static final String WORD_PATTERN = "[а-яА-ЯёЁ]+";
    public static final String VOWELS = "аеёиоуэюяы";
    public static final String CONSONANTS = "бБвВгГдДжЖзЗйЙкКлЛмМнНпПрРсСтТфФхХцЦчЧшШщЩ";
    private static final char[] arrayVowels = VOWELS.toCharArray();
    private static final char[] arrayConsonants = CONSONANTS.toCharArray();

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            String word = matcher.group();
            process (word);
        }
    }
    private static void process(String word) {
        for (char arrayVowel: arrayVowels) {
            boolean lastVowel = word.endsWith(String.valueOf(arrayVowel));
            if (lastVowel) {
                for (char arrayConsonant: arrayConsonants) {
                    boolean firstConsonant = word.startsWith(String.valueOf(arrayConsonant));
                    if (firstConsonant) {
                        System.out.println(word);
                        return;
                    }
                }
            }
        }
    }
}
