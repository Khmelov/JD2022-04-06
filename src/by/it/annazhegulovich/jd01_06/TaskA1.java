package by.it.annazhegulovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder copyPoem = new StringBuilder(Poem.text);
        Matcher matcher = compile.matcher(copyPoem);
        while (matcher.find()){
            int posit = matcher.start();
            copyPoem.setCharAt(posit+3, '#');
            int lengthword = matcher.group().length();
        if (lengthword>6){
            copyPoem.setCharAt(posit+6,'#');
        }
        }
        System.out.println(copyPoem);
    }
}
