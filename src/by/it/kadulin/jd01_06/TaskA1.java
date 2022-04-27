package by.it.kadulin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuffer dynText = new StringBuffer(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(dynText);
        while (matcher.find()) {
//            String word = matcher.group();
//            System.out.println(word + " pos:" + matcher.start());
            int position = matcher.start();
            dynText.setCharAt(position + 3, '#');
            if (matcher.group().length() > 6) {
                dynText.setCharAt(position + 6, '#');
            }
        }
        System.out.println(dynText);
    }
}
