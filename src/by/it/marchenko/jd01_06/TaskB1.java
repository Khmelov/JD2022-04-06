package by.it.marchenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static final String RUS_WORDS_MIN2_PATTERN_ = "[а-яА-ЯёЁ]{2,}";
    private static final String RUS_VOWEL = "аеёиоуыэюя";
    private static final String RUS_CONSONANT = "бвгджзйклмнпрстфхцчшщьъ";

    public static void main(String[] args) {
        Pattern russianWordsPattern = Pattern.compile(RUS_WORDS_MIN2_PATTERN_);
        Matcher words = russianWordsPattern.matcher(Poem.text);
        while (words.find()) {
            String word = words.group();
            if (checkWordCondition(word.toLowerCase())) {
                System.out.println(word);
            }
        }
    }

    private static boolean checkWordCondition(String word) {
        char firstLetter = word.charAt(0);
        char lastLetter = word.charAt(word.length() - 1);
        return RUS_CONSONANT.indexOf(firstLetter) >= 0 && RUS_VOWEL.indexOf(lastLetter) >= 0;
    }
}
