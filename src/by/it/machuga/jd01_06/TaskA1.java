package by.it.machuga.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int startPosition = matcher.start();
            text.setCharAt(startPosition + 3, '#');
            int length = matcher.group().length();
            if (length > 6) {
                text.setCharAt(startPosition + 6, '#');
            }
        }
        System.out.println(text);
    }
}
