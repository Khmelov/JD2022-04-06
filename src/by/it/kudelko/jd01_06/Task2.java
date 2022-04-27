package by.it.kudelko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        StringBuffer dynText = new StringBuffer(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]");
        Matcher matcher = pattern.matcher(dynText);
        String[] word;
        int[] numbers;
        while (matcher.find()) {
        }
    }
}
