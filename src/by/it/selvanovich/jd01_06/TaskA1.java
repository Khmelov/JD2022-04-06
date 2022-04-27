package by.it.selvanovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]{4,}");
        Matcher matcher = pattern.matcher(dynText);
        while (matcher.find()) {
            int startPosition = matcher.start();
            dynText.setCharAt(startPosition + 3, '#');
            int lenght = matcher.group().length();
            if (lenght > 6) {
                dynText.setCharAt( startPosition + 6, '#');
            }
        }
        System.out.println(dynText);
    }
}
