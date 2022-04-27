package by.it.kadulin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static final String[] vowels = {"А", "а", "И", "и", "Е", "е", "Ё", "ё", "О", "о", "У", "у", "Ы", "ы", "Э", "э", "Ю", "ю", "Я", "я"};
    private static final String[] consonants = {"Б", "б", "В", "в", "Г", "г", "Д", "д", "Ж", "ж", "З", "з", "Й", "й", "К", "к", "Л", "л", "М", "м", "Н", "н", "П", "п", "Р", "р", "С", "с", "Т", "т", "Ф", "ф", "Х", "х", "Ц", "ц", "Ч", "ч", "Ш", "ш", "Щ", "щ"} ;

    public static void main(String[] args) {
        wordsFinder(Poem.text);
    }

    private static void wordsFinder(String poem) {
        Pattern pattern = Pattern.compile("[А-Яа-яЁё]{2,}");
        Matcher matcher = pattern.matcher(poem);
        while (matcher.find()) {
            String str = matcher.group();
            boolean startAtConsonants = false;
            for (int i = 0; i < consonants.length; i++) {
                if (Character.toString(str.charAt(0)).equals(consonants[i])) {
                    startAtConsonants = true;
                    break;
                }
            }
            if (startAtConsonants) {
                for (int i = 0; i < vowels.length; i++) {
                    if (Character.toString(str.charAt(str.length() - 1)).equals(vowels[i])) {
                        System.out.println(str);
                        break;
                    }
                }
            }
        }
    }
}
