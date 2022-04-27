package by.it.kameisha.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static final char[] vowels = {'у', 'ё', 'е', 'ы', 'а', 'о', 'э', 'я', 'и', 'ю'};
    private static final char[] consonants = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            String word = matcher.group();
            printWord(word);
        }
    }

    private static void printWord(String word) {
        for (char vowel : vowels) {
            if (word.length() > 1 && word.toLowerCase().endsWith(String.valueOf(vowel))) {
                for (char consonant : consonants) {
                    if (word.toLowerCase().startsWith(String.valueOf(consonant))) {
                        System.out.println(word);
                        return;
                    }
                }
            }
        }
    }
}
