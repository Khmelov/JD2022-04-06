package by.it.kameisha.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dynamicText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(dynamicText);
        while (matcher.find()) {
            int startPosition = matcher.start();
            dynamicText.setCharAt(startPosition + 3, '#');
            if (matcher.group().length() > 6) {
                dynamicText.setCharAt(startPosition + 6, '#');
            }
        }
        System.out.println(dynamicText);
    }
}
