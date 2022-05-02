package by.it.arsenihlaz.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder changetext = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(changetext);

        while (matcher.find()) {
            int startPosition = matcher.start();
            changetext.setCharAt(startPosition + 3, '#');
            if (matcher.group().length() > 6){
                changetext.setCharAt(startPosition + 6, '#');
            }
        }
        System.out.println(changetext);
    }
}
