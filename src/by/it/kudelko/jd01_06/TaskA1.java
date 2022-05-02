package by.it.kudelko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuffer dynText = new StringBuffer(Poem.text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m = p.matcher(dynText);
        while (m.find()) {
            int startPosition = m.start();
            dynText.setCharAt(startPosition+3,'#');
            int lenght = m.group().length();
            if (lenght>6){
                dynText.setCharAt(startPosition+6,'#');
            }
        }
        System.out.println(dynText);
    }
}


