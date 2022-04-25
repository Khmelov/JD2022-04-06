package by.it.ragach.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TaskB1 {
    private static String vowels = "аоиеёэыуюя";
    private static String consonants = "бвгджзйклмнпрстфхцчшщ";


    public static void main(String[] args) {

        String text = Poem.text;
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            if ((checkLetters((word.toLowerCase())))){
            System.out.println(word);

        }

    }

}
    private static boolean checkLetters(String word) {
        char firstLetter = word.charAt(0);
        char lastLetter = word.charAt(word.length()-1);


        return consonants.indexOf(firstLetter)>=0 &&vowels.indexOf(lastLetter)>=0;
    }
    }


