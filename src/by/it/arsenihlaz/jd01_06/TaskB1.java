package by.it.arsenihlaz.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static String[] vowel = {"И", "а", "у", "ы", "я", "е", "о", "и", "ю", "э", "ё", "А", "У", "Ы", "Я", "Е", "О", "Ю", "Э", "Ё"};
    private static String[] novowel = {"ц", "к", "н", "г", "ш", "щ", "з", "х", "ф", "в", "п", "р", "л", "д", "ж", "ч", "с", "м", "т", "ь", "б", "ъ", "Ц", "К", "Н", "Г", "Ш", "Щ", "З", "Х", "Ф", "В", "П", "Р", "Л", "Д", "Ж", "Ч", "С", "М", "Т", "Ь", "Б", "Ю"};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            for (int i = 0; i < vowel.length; i++) {
                if (word.length() > 1 && word.endsWith(vowel[i])) {
                    for (int j = 0; j < novowel.length; j++) {
                        if (word.startsWith(novowel[j])) {
                            System.out.println(word);
                            break;
                        }
                    }
                }
            }
        }
    }
}
