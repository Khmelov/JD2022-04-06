package by.it.machuga.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static final String VOWELS = "аеёиоуыэюя";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            boolean firstSymbolCheck = isVowel(word.charAt(0));
            boolean lastSymbolCheck = isVowel(word.charAt(word.length() - 1));
            if (!firstSymbolCheck && lastSymbolCheck) {
                System.out.println(word);
            }
        }
    }

    private static boolean isVowel(char symbol) {
        int index = VOWELS.indexOf(Character.toLowerCase(symbol));
        return index >= 0;
    }
}
