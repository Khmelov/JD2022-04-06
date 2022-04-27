package by.it.annazhegulovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String []  wordsOll={};
    private static int [] count = {};

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яA-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            process(word);
        }
        printResult();
    }

    private static void process(String word) {
        for (int i = 0; i < wordsOll.length; i++) {
            if (word.equals(wordsOll[i])){
                count[i]++;
                return;
            }
        }
            wordsOll= Arrays.copyOf(wordsOll,wordsOll.length+1);
            wordsOll[wordsOll.length-1]=word;
            count= Arrays.copyOf(count,count.length+1);
            count[count.length-1]=1;
        }


    private static void printResult() {
        for (int i = 0; i < wordsOll.length; i++) {
            System.out.printf("%s=%d%n", wordsOll[i], count[i]);

        }
    }
}
