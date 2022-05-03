package by.it.avramchuk.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static String[] words = {};

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher = pattern.matcher(Poem.text);


        while (matcher.find()){
            String word = matcher.group();
            process(word);
        }
        printResult();

    }

    private static void process(String word) {
        String [] vowels = {"а", "я", "о", "ё", "у", "ю",  "ы", "и", "э","е"};
        for (String vowel : vowels) {
            if (String.valueOf(word.charAt(0)).equalsIgnoreCase(vowel)){
                return;
            }
        }
        for (String vowel : vowels) {
            if (String.valueOf(word.charAt(word.length()-1)).equalsIgnoreCase(vowel)){
                words = Arrays.copyOf(words, words.length+1);
                words[words.length-1] = word;
                return;
            }
        }

    }

    private static void printResult() {
        for (String word : words) {

            System.out.println(word);
        }

    }
}
