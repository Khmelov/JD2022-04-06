package by.it.marchenko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    private static final int FIRST_REPLACE_POSITION = 4;
    private static final int LAST_REPLACE_POSITION = 7;
    private static final char REPLACE_SYMBOL = '#';
    private static final String WORD_RUS_PATTERN_MIN_LENGTH =
            String.format("[а-яА-яёЁ]{%d,}", FIRST_REPLACE_POSITION);

    public static void main(String[] args) {
        Pattern russianWords = Pattern.compile(WORD_RUS_PATTERN_MIN_LENGTH);
        StringBuilder textForEditing = new StringBuilder(Poem.text);
        Matcher words = russianWords.matcher(textForEditing);
        while (words.find()) {
            textForEditing.setCharAt(words.start() + FIRST_REPLACE_POSITION - 1, REPLACE_SYMBOL);
            if (words.group().length() >= LAST_REPLACE_POSITION) {
                textForEditing.setCharAt(words.start() + LAST_REPLACE_POSITION - 1, REPLACE_SYMBOL);
            }
        }
        System.out.println(textForEditing);
    }
}
