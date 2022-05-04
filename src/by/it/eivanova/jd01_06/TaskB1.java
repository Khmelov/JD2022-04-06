package by.it.eivanova.jd01_06;



//Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся гласной буквой.


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class TaskB1 {

    //private static final
    static char[] g = {'у', 'ё', 'е', 'ы', 'а', 'о', 'э', 'я', 'и', 'ю', 'У', 'Ё', 'Е', 'Ы', 'А', 'О', 'Э', 'Я', 'И', 'Ю'};

    //private static final
    static char[] s = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ' };



    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher = pattern.matcher(Poem.text);


        while (matcher.find()) {
            String word = matcher.group();
            process (word);
        }
    }

    private static void process(String word) {

        for (char vowel : g) {
            if (word.length() > 1 && word.toLowerCase().endsWith(String.valueOf(vowel))) {
                for (char consonant : s) {
                    if (word.toLowerCase().startsWith(String.valueOf(consonant))) {
                        System.out.println(word);
                        return;

                    }
                }
            }
        }
    }
}