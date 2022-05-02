package by.it.avramchuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder  dynText = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(dynText);
        System.out.println(dynText);
        while (matcher.find()){
            int startPosition = matcher.start();
            dynText.setCharAt(startPosition+3, '#');
            int length = matcher.group().length();
            if (length>6){
                dynText.setCharAt(startPosition+6, '#');
            }
        }
        System.out.println(dynText);
    }
}
