package by.it.korennaya.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args){
        StringBuilder dynText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
           Matcher matcher = pattern.matcher(dynText);
           while(matcher.find()) {
               int position = matcher.start();
               dynText.setCharAt(position + 3, '#');
               int length = matcher.group().length();
               if (length > 6) {
               dynText.setCharAt(position+6,'#')   ;
               }
           }
         System.out.println(dynText);
    }
}
