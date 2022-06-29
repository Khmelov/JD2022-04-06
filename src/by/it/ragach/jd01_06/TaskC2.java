package by.it.ragach.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        long startTimeSlow = System.currentTimeMillis();
        String text = slow(Poem.text);
        long endTimeSlow = System.currentTimeMillis();
        System.out.println(text);
        System.out.println("Time: " + (endTimeSlow - startTimeSlow) + "ms");


        long startTimeFast = System.currentTimeMillis();
        text = fast(Poem.text);


    }

    private static String fast(String sourceText) {
        StringBuilder stringBuilder = new StringBuilder(100000);
        while (stringBuilder.length() < 100000) {
            Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+");
            Matcher matcher = pattern.matcher(sourceText);
            while (matcher.find()) {
                String word = matcher.group();
                String space = " ";
                stringBuilder = stringBuilder.append(word);
                stringBuilder = stringBuilder.append(space);

            }

        }

        String text = stringBuilder.toString();
        return text;
    }

    private static String slow(String sourceText) {
        String text = new String();
        while (text.length() < 100000) {
            Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+");
            Matcher matcher = pattern.matcher(sourceText);
            while (matcher.find()) {
                String word = matcher.group();
                String space = " ";
                text = text.concat(word);
                text = text.concat(space);
            }

        }
        return text;
    }


}
